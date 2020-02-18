package com.test.controllers;

import com.test.entities.Campaign;
import com.test.entities.Comment;
import com.test.entities.User;
import com.test.repositories.CampaignRepository;
import com.test.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/campaigns/{id}")
public class CampaignViewController {

    @Autowired
    private CampaignRepository campaignRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping
    public String view(@PathVariable Integer id, Model model) {
        Campaign campaign = campaignRepository.findById(id);
        model.addAttribute("campaign", campaign);

        Iterable<Comment> comments = commentRepository.findByPath(id);
        model.addAttribute("comments", comments);
        return "viewCampaign";
    }

    @PostMapping
    public String addComment(
        @PathVariable Integer id, @AuthenticationPrincipal User user, @RequestParam String text,
        @RequestParam("file") MultipartFile file, Model model) throws IOException {
        Campaign campaign = campaignRepository.findById(id);
        model.addAttribute("campaign", campaign);

        Comment comment = new Comment(id, user, text);

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

        commentRepository.save(comment);
        Iterable<Comment> comments = commentRepository.findByPath(id);
        model.addAttribute("comments", comments);
        return "viewCampaign";
    }

}
