package com.test.controllers;

import com.test.entities.Campaign;
import com.test.entities.User;
import com.test.repositories.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/create")
public class CampaignCreateController {

    @Autowired
    private CampaignRepository campaignRepository;

    @GetMapping
    public String createCampaign() {
        return "createCampaign";
    }

    @PostMapping
    public String addCampaign(@AuthenticationPrincipal User user, @RequestParam String campaignName,
                              @RequestParam String topic, @RequestParam String description,
                              @RequestParam Double amountTotal, @RequestParam String logo) {
        if (logo == "") {
            logo = "no_image.png";
        }

        Campaign campaign = new Campaign(user, campaignName, topic, description, amountTotal, logo);
        campaignRepository.save(campaign);

        return "index";
    }

}
