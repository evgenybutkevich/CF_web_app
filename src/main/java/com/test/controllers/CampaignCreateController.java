package com.test.controllers;

import com.test.entities.Campaign;
import com.test.entities.Topic;
import com.test.entities.User;
import com.test.repositories.CampaignRepository;
import com.test.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Controller
public class CampaignCreateController {

    @Autowired
    private CampaignRepository campaignRepository;

    @Autowired
    private TopicRepository topicRepository;


    @GetMapping("/create")
    public String create(Model model) {

        Iterable<Topic> topics = topicRepository.findAll();
        model.addAttribute("topics", topics);
        return "createCampaign";
    }


    @PostMapping("/create")
    public String addCampaign(@AuthenticationPrincipal User user, @Valid Campaign campaign,
                              BindingResult bindingResult, @RequestParam String expiry_date,
                              Model model) throws ParseException {

        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtilities.getErrors(bindingResult);
            model.mergeAttributes(errorsMap);

            model.addAttribute("campaign", campaign);
            Iterable<Topic> topics = topicRepository.findAll();
            model.addAttribute("topics", topics);
            return "createCampaign";
        } else {
            campaign.setAuthor(user);
            campaign.setAmountCollected(0.0);
            campaign.setDateOfCreation(new Date());

            Date dateOfExpiry = new SimpleDateFormat("dd.MM.yyyy").parse(expiry_date);
            campaign.setDateOfExpiry(dateOfExpiry);

            if (campaign.getLogo() == "") {
                campaign.setLogo("city.jpg");
            }

            model.addAttribute("campaign", "Campaign successfully created!");
            campaignRepository.save(campaign);
        }

        return "redirect:/campaigns";
    }

}
