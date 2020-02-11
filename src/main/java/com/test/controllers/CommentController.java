package com.test.controllers;

import com.test.entities.Comment;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.test.repositories.CommentRepository;

import java.util.Map;

@Controller
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("/comment")
    public String comment() {
        return "comment";
    }

    @PostMapping("/comment")
    public String addComment(

        @RequestParam String text, Map<String, Object> model) {
            Comment comment = new Comment(text);
            commentRepository.save(comment);
            Iterable<Comment> comments = commentRepository.findAll();
            model.put("comments", comments);
            return "comment";
        }
}

