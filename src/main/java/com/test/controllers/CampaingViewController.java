package com.test.controllers;

import com.test.entities.Campaing;
import com.test.entities.Comment;
import com.test.repositories.CampaingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class CampaingViewController {

    @Autowired
    private CampaingRepository campaingRepository;

    @GetMapping
    public String view(Model model) {
        Iterable<Campaing> campaings = campaingRepository.findAll();
        model.addAttribute("campaings", campaings);
        return "viewCampaing";
    }

}
