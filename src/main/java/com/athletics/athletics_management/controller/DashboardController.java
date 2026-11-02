
package com.athletics.athletics_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {

    @GetMapping("/coach/dashboard")
    public String coachDashboard() {
        return "coach-dashboard";
    }

    @GetMapping("/athlete/dashboard")
    public String athleteDashboard() {
        return "athlete-dashboard";
    }
}
