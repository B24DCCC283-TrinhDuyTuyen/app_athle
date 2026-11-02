
package com.athletics.athletics_management.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({ "/", "/home" })
    public String home(Authentication authentication) {

        if (authentication == null
                || !authentication.isAuthenticated()) {
            return "redirect:/login";
        }

        boolean isCoach = authentication.getAuthorities()
                .stream()
                .anyMatch(authority -> authority.getAuthority().equals("ROLE_COACH"));

        boolean isAthlete = authentication.getAuthorities()
                .stream()
                .anyMatch(authority -> authority.getAuthority().equals("ROLE_ATHLETE"));

        if (isCoach) {
            return "redirect:/coach/dashboard";
        }

        if (isAthlete) {
            return "redirect:/athlete/dashboard";
        }

        return "redirect:/login?error";
    }
}
