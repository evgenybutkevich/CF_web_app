package com.test.controllers;

import com.test.entities.Campaing;
import com.test.repositories.CampaingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/create")
public class CampaingCreateController {

    @Autowired
    private CampaingRepository campaingRepository;

    @GetMapping
    public String createCampaing() {
        return "createCampaing";
    }

    @PostMapping
    public String addCampaing(@RequestParam String name, @RequestParam String topic, @RequestParam String description,
                              @RequestParam Double amountTotal, @RequestParam String logo) {
        Campaing campaing = new Campaing(name, topic, description, amountTotal, logo);
        campaingRepository.save(campaing);

        return "index";
    }

}
