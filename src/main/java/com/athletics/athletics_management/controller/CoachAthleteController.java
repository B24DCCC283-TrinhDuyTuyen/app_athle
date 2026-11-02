
package com.athletics.athletics_management.controller;

import com.athletics.athletics_management.service.CoachAthleteService;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CoachAthleteController {

    private final CoachAthleteService coachAthleteService;

    public CoachAthleteController(
            CoachAthleteService coachAthleteService) {
        this.coachAthleteService = coachAthleteService;
    }

    @GetMapping("/athlete/coaches")
    public String showCoaches(Model model) {
        model.addAttribute(
                "coaches",
                coachAthleteService.getAllCoaches());

        return "athlete-coaches";
    }

    @PostMapping("/athlete/coaches/{coachId}/request")
    public String sendRequest(
            @PathVariable Long coachId,
            Authentication authentication,
            RedirectAttributes redirectAttributes) {

        try {
            coachAthleteService.sendRequest(
                    authentication.getName(),
                    coachId);

            redirectAttributes.addFlashAttribute(
                    "success",
                    "Đã gửi yêu cầu liên kết đến huấn luyện viên.");
        } catch (IllegalArgumentException exception) {
            redirectAttributes.addFlashAttribute(
                    "error",
                    exception.getMessage());
        }

        return "redirect:/athlete/coaches";
    }

    @GetMapping("/athlete/coach-requests")
    public String showAthleteRequests(
            Authentication authentication,
            Model model) {

        model.addAttribute(
                "requests",
                coachAthleteService.getRequestsForAthlete(
                        authentication.getName()));

        return "athlete-coach-requests";
    }

    @GetMapping("/coach/requests")
    public String showCoachRequests(
            Authentication authentication,
            Model model) {

        model.addAttribute(
                "requests",
                coachAthleteService.getRequestsForCoach(
                        authentication.getName()));

        return "coach-requests";
    }

    @PostMapping("/coach/requests/{requestId}/accept")
    public String acceptRequest(
            @PathVariable Long requestId,
            Authentication authentication,
            RedirectAttributes redirectAttributes) {

        return respondToRequest(
                requestId, authentication, redirectAttributes, true);
    }

    @PostMapping("/coach/requests/{requestId}/reject")
    public String rejectRequest(
            @PathVariable Long requestId,
            Authentication authentication,
            RedirectAttributes redirectAttributes) {

        return respondToRequest(
                requestId, authentication, redirectAttributes, false);
    }

    private String respondToRequest(
            Long requestId,
            Authentication authentication,
            RedirectAttributes redirectAttributes,
            boolean accept) {

        try {
            coachAthleteService.respondToRequest(
                    authentication.getName(),
                    requestId,
                    accept);

            redirectAttributes.addFlashAttribute(
                    "success",
                    accept
                            ? "Đã chấp nhận yêu cầu liên kết."
                            : "Đã từ chối yêu cầu liên kết.");
        } catch (IllegalArgumentException exception) {
            redirectAttributes.addFlashAttribute(
                    "error",
                    exception.getMessage());
        }

        return "redirect:/coach/requests";
    }
}
