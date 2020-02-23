package com.test.services;

import com.test.entities.Role;
import com.test.entities.User;
import com.test.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.UUID;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MailService mailService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public String addUser(User user, String birthday) throws ParseException {
        User usernameFromDatabase = userRepository.findByUsername(user.getUsername());

        if (usernameFromDatabase != null) {
            return "username exists";
        }

        User emailFromDatabase = userRepository.findByEmail(user.getEmail());

        if (emailFromDatabase != null) {
            return "email exists";
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActivationCode(UUID.randomUUID().toString());
        user.setRegistrationDate(new Date());

        if (birthday != "") {
            Date birth_date = new SimpleDateFormat("dd.MM.yyyy").parse(birthday);
            user.setBirthDate(birth_date);
        } else {
            user.setBirthDate(null);
        }

        if (user.getAvatar() == "") {
            if (user.getSex() == "male") {
                user.setAvatar("user-male.png");
            } else {
                user.setAvatar("user-female.png");
            }
        }

        user.setActive(false);
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);

        if (!StringUtils.isEmpty(user.getEmail())) {
            String message = String.format(
                    "Hello, %s! \n" +
                        "Please, confirm your email by visiting next link: http://localhost:8080/activation/%s",
                            user.getFirstName(), user.getActivationCode());

            mailService.send(user.getEmail(), "Activation code", message);
        }

        return "registered";
    }

    public boolean activateUser(String activationCode) {
        User user = userRepository.findByActivationCode(activationCode);

        if (user == null) {
            return false;
        }

        user.setActivationCode(null);
        user.setActive(true);
        userRepository.save(user);

        return true;
    }

}
