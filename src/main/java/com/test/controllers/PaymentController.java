package com.test.controllers;

import com.test.entities.Campaign;
import com.test.entities.Payment;
import com.test.entities.User;
import com.test.repositories.CampaignRepository;
import com.test.repositories.PaymentRepository;
import com.test.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.crypto.Data;
import java.util.Date;

@Controller
public class PaymentController {

    @Autowired
    private CampaignRepository campaignRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PaymentRepository paymentRepository;


    @GetMapping("/payments/{id}")
    public String payments(@PathVariable Integer id, Model model) {
        Campaign campaign = campaignRepository.findById(id);
        model.addAttribute("campaign", campaign);

        User user = campaign.getAuthor();
        model.addAttribute("user", user);

        return "payment";
    }


    @PostMapping("/payments/{id}")
    public String addPayment(@AuthenticationPrincipal User user, Payment payment,
                             @PathVariable Integer id, Model model) {

        Campaign campaign = campaignRepository.findById(id);

        payment.setRecipient(campaign);
        payment.setAuthor(user);
        campaign.setAmountCollected(campaign.getAmountCollected() + payment.getAmount());
        payment.setDateOfCreation(new Date());
        paymentRepository.save(payment);

        return "redirect:/campaigns/{id}";
    }
}
