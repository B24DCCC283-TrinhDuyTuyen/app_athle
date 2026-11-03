
package com.athletics.athletics_management.controller;

import com.athletics.athletics_management.service.CoachAthleteService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LinkedAthleteController {

    private final CoachAthleteService coachAthleteService;

    public LinkedAthleteController(CoachAthleteService coachAthleteService) {
        this.coachAthleteService = coachAthleteService;
    }

    @GetMapping("/coach/athletes")
    public String showLinkedAthletes(Authentication authentication, Model model) {
        model.addAttribute(
                "links",
                coachAthleteService.getLinkedAthletesForCoach(authentication.getName()));

        return "coach-linked-athletes";
    }

    @GetMapping("/athlete/linked-coaches")
    public String showLinkedCoaches(Authentication authentication, Model model) {
        model.addAttribute(
                "links",
                coachAthleteService.getLinkedCoachesForAthlete(authentication.getName()));

        return "athlete-linked-coaches";
    }
}
