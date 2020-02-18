package com.test.controllers;

import com.test.entities.Campaing;
import com.test.entities.Comment;
import com.test.repositories.CampaingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class CampaingViewController {

    @Autowired
    private CampaingRepository campaingRepository;

    @GetMapping("/{id}")
    public String view(@PathVariable Integer id, Model model) {
        Campaing campaing = campaingRepository.findById(id);
        model.addAttribute("campaing", campaing);
        return "viewCampaing";
    }

}
