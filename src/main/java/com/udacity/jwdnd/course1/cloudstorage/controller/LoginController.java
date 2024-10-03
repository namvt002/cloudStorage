package com.udacity.jwdnd.course1.cloudstorage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller login.
 */
@Controller
public class LoginController {

    /**
     * View login.
     */
    @GetMapping("/login")
    public String viewLogin(Model model) {
        return "login";
    }
}
