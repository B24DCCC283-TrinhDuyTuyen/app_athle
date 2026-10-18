package com.athletics.athletics_management.controller;

import com.athletics.athletics_management.entity.Role;
import com.athletics.athletics_management.entity.User;
import com.athletics.athletics_management.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegisterForm() {
        return "register";
    }

    @PostMapping("/register")
    public String register(
            @RequestParam String fullName,
            @RequestParam String username,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam Role role,
            Model model,
            RedirectAttributes redirectAttributes) {

        try {
            User user = userService.register(
                    username,
                    email,
                    password,
                    fullName,
                    role);

            redirectAttributes.addFlashAttribute(
                    "success",
                    "Đăng ký tài khoản thành công!");

            return "redirect:/login";

        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("fullName", fullName);
            model.addAttribute("username", username);
            model.addAttribute("email", email);
            model.addAttribute("selectedRole", role);

            return "register";
        }
    }
}
