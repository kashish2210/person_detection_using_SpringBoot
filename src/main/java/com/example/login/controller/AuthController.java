package com.example.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.login.model.User;
import com.example.login.repository.UserRepository;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String home() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model) {

        return userRepository.findByUsername(username)
                .filter(user -> user.getPassword().equals(password))
                .map(user -> {
                    model.addAttribute("username", username);
                    return "redirect:/welcome?username=" + username; // redirect to welcome
                })
                .orElseGet(() -> {
                    model.addAttribute("error", "Invalid username or password!");
                    return "login";
                });
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username,
                           @RequestParam String password,
                           Model model) {
        if (userRepository.findByUsername(username).isPresent()) {
            model.addAttribute("error", "Username already exists!");
            return "register";
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userRepository.save(user);
        return "login";
    }

    @GetMapping("/welcome")
    public String welcome(@RequestParam String username, Model model) {
        model.addAttribute("username", username);
        return "welcome";
    }
}
