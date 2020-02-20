package com.test.controllers;

import com.test.entities.User;
import com.test.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.Map;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@Valid User user, BindingResult bindingResult,
                          @RequestParam String birthday, Model model) throws ParseException {

        if (user.getPassword() != null && !user.getPassword().equals(user.getPassword2())) {
            model.addAttribute("passwordError", "Passwords are different!");
            return "registration";
        }

        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtilities.getErrors(bindingResult);
            model.mergeAttributes(errorsMap);
            return "registration";
        }

        if (userService.addUser(user, birthday) == "username exists") {
            model.addAttribute("usernameError", "User with the same login already exists!");
            return "registration";
        } else if (userService.addUser(user, birthday) == "email exists") {
            model.addAttribute("emailError", "User with the same email already exists!");
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
            model.addAttribute("inactive", "Activation code is not found!");
        }

        return "login";
    }

}
