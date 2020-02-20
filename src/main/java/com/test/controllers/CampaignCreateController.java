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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/create")
public class CampaignCreateController {

    @Autowired
    private CampaignRepository campaignRepository;

    @Autowired
    private TopicRepository topicRepository;

    @GetMapping
    public String createCampaign(Model model) {
        Iterable<Topic> topics = topicRepository.findAll();
        model.addAttribute("topics", topics);
        return "createCampaign";
    }

    @PostMapping
    public String addCampaign(
            @AuthenticationPrincipal User user, Campaign campaign, @RequestParam String expiry_date) throws ParseException {

        if (campaign.getLogo() == "") {
            campaign.setLogo("no_image.png");
        }

        Date dateOfExpiry = new SimpleDateFormat("dd.MM.yyyy").parse(expiry_date);
        campaign.setDateOfCreation(new Date());
        campaign.setDateOfExpiry(dateOfExpiry);

        campaign.setAuthor(user);
        campaignRepository.save(campaign);
        return "redirect:/";
    }

}
