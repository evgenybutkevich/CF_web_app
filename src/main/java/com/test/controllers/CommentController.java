package com.test.controllers;

import com.test.entities.Comment;
import com.test.entities.User;
import com.test.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping
    public String comment(Model model) {
        Iterable<Comment> comments = commentRepository.findAll();
        model.addAttribute("comments", comments);
        return "comments";
    }

    @PostMapping
    public String addComment(

            @AuthenticationPrincipal User user, @RequestParam String text, Model model) {
            Comment comment = new Comment(text, user);
            commentRepository.save(comment);
            Iterable<Comment> comments = commentRepository.findAll();
            model.addAttribute("comments", comments);
            return "comments";
        }
}

