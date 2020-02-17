package com.test.controllers;

import com.test.entities.Comment;
import com.test.entities.User;
import com.test.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping
    public String comment(Model model) {
        Iterable<Comment> comments = commentRepository.findAll();
        model.addAttribute("comments", comments);
        return "comments";
    }

    @PostMapping
    public String addComment(

            @AuthenticationPrincipal User user, @RequestParam String text, @RequestParam("file") MultipartFile file, Model model) throws IOException {
            Comment comment = new Comment(text, user);

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
            Iterable<Comment> comments = commentRepository.findAll();
            model.addAttribute("comments", comments);
            return "comments";
        }
}

