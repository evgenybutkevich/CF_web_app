package com.test.controllers;

import com.test.entities.Campaign;
import com.test.entities.Comment;
import com.test.entities.Payment;
import com.test.entities.User;
import com.test.repositories.CampaignRepository;
import com.test.repositories.CommentRepository;
import com.test.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Controller
public class CampaignViewController {

    @Autowired
    private CampaignRepository campaignRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Value("${upload.path}")
    private String uploadPath;


    @GetMapping("/campaigns")
    public String campaigns(Model model) {
        Iterable<Campaign> campaigns = campaignRepository.findAll();
        model.addAttribute("campaigns", campaigns);
        return "campaigns";
    }


    @GetMapping("/campaigns/{id}")
    public String view(@PathVariable Integer id, Model model) {

        Campaign campaign = campaignRepository.findById(id);
        model.addAttribute("campaign", campaign);

        Iterable<Comment> comments = commentRepository.findByRecipient(campaign);
        model.addAttribute("comments", comments);

        Iterable<Payment> payments = paymentRepository.findByRecipient(campaign);
        model.addAttribute("payments", payments);
        return "viewCampaign";
    }


    @PostMapping("/campaigns/{id}")
    public String addComment(@PathVariable Integer id, @AuthenticationPrincipal User user,
                             @Valid Comment comment, BindingResult bindingResult,
                             @RequestParam("file") MultipartFile file, Model model) throws IOException {

        Campaign campaign = campaignRepository.findById(id);
        model.addAttribute("campaign", campaign);

        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtilities.getErrors(bindingResult);
            model.mergeAttributes(errorsMap);

            model.addAttribute("comment", comment);
        } else {
            comment.setRecipient(campaign);
            comment.setAuthor(user);

            if (file != null && !file.getOriginalFilename().isEmpty()) {
                File uploadDir = new File(String.format("%s%s%s", System.getProperty("user.dir"), File.separatorChar, uploadPath));

                if (!uploadDir.exists()) {
                    uploadDir.mkdir();
                }

                String currentPath = uploadDir.getPath();
                String uuidFile = UUID.randomUUID().toString();
                String resultFileName = uuidFile + "." + file.getOriginalFilename();
                file.transferTo(new File(currentPath + "/" + resultFileName));
                comment.setFilename(resultFileName);
            }

            comment.setDateOfCreation(new Date());
            model.addAttribute("comment", null);
            commentRepository.save(comment);
        }

        Iterable<Comment> comments = commentRepository.findByRecipient(campaign);
        model.addAttribute("comments", comments);

        Iterable<Payment> payments = paymentRepository.findByRecipient(campaign);
        model.addAttribute("payments", payments);
        return "viewCampaign";
    }

}


