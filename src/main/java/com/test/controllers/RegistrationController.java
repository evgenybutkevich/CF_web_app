package com.test.controllers;

import com.test.entities.Role;
import com.test.entities.User;
import com.test.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String registration() {
        return "registration";
    }

    @PostMapping
    public String addUser(User user, @RequestParam String birthday, Model model) throws ParseException {
        User userFromDatabase = userRepository.findByUsername(user.getUsername());

        if (userFromDatabase != null) {
            model.addAttribute("message", "User exists!");
            return "registration";
        }

        Date birth_date = new SimpleDateFormat("dd.MM.yyyy").parse(birthday);

        user.setActive(true);
        user.setBirth_date(birth_date);
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);
        return "redirect:/login";
    }

}
