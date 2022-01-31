package com.aziz.vocabulary.controllers;

import com.aziz.vocabulary.entities.User;
import com.aziz.vocabulary.entities.Word;
import com.aziz.vocabulary.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String showUserList(Model model) {
//        model.addAttribute("username", username);
//        model.addAttribute("email", email);
//        model.addAttribute("name", name);
        List<User> users = new ArrayList<>();
        users = userRepository.findAll();

        System.out.println("users = " + users);
//        model.addAllAttributes("users", userRepository.findAll());
        return "users";
    }

    @PostMapping("/add-user")
    public String createUser(@ModelAttribute(value = "user") User user) {


        System.out.println(user.getId());
        System.out.println(user.getName());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        userRepository.save(user);
        return "redirect:/users";
    }
}
