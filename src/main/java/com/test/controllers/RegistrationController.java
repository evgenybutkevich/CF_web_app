package com.test.controllers;

import com.test.entities.User;
import com.test.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, @RequestParam String birthday, Model model) throws ParseException {

        if (userService.addUser(user, birthday) == "username exists") {
            model.addAttribute("name", "User with the same login already exists!");
            return "registration";
        } else if (userService.addUser(user, birthday) == "email exists") {
            model.addAttribute("email", "User with the same email already exists!");
            return "registration";
        }

        return "redirect:/login";
    }

    @GetMapping("/activation/{activationCode}")
    public String activation(@PathVariable String activationCode, Model model) {
        boolean isActivated = userService.activateUser(activationCode);

        if (isActivated) {
            model.addAttribute("active", "Email confirmed, user successfully activated!");
        } else {
            model.addAttribute("active", "Activation code is not found!");
        }

        return "login";
    }

}
