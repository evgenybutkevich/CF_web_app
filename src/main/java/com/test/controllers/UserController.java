package com.test.controllers;

import com.test.entities.Role;
import com.test.entities.User;
import com.test.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public String users(Model model) {
        Iterable<User> users = userRepository.findAll();
        model.addAttribute("usersAll", users);
        return "usersAll";
    }


    @GetMapping("/view/{user}")
    public String user(@PathVariable User user, Model model) {
        model.addAttribute("user", user);
        return "userView";
    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/edit/{user}")
    public String userEdit(@PathVariable User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/edit/{user}")
    public String saveUser(@PathVariable User user, @Valid User editUser, BindingResult bindingResult,
                           @RequestParam String birthday, @RequestParam Map<String, String> form, Model model) throws ParseException {

        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtilities.getErrors(bindingResult);
            model.mergeAttributes(errorsMap);
            return "userEdit";
        } else {
            user.setUsername(editUser.getUsername());
            user.setEmail(editUser.getEmail());
            user.setFirstName(editUser.getFirstName());
            user.setLastName(editUser.getLastName());
            user.setSex(editUser.getSex());

            if (user.getBirthDate() != null && birthday != "") {
                Date birth_date = new SimpleDateFormat("dd.MM.yyyy").parse(birthday);
                user.setBirthDate(birth_date);
            } else if (user.getBirthDate() == null && birthday != "") {
                Date birth_date = new SimpleDateFormat("dd.MM.yyyy").parse(birthday);
                user.setBirthDate(birth_date);
            }

            if (editUser.getAvatar() == "") {
                if (editUser.getSex() == "male") {
                    user.setAvatar("user-male.png");
                } else {
                    user.setAvatar("user-female.png");
                }
            }

            Set<String> roles = Arrays.stream(Role.values()).map(Role::name).collect(Collectors.toSet());
            user.getRoles().clear();

            for (String key : form.keySet()) {
                if (roles.contains(key)) {
                    user.getRoles().add(Role.valueOf(key));
                }
            }

            userRepository.save(user);
        }

        return "redirect:/users";
    }

}
