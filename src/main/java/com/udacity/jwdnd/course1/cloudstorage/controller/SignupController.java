package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controller Signup.
 */
@Controller
public class SignupController {
    private UserService userService;

    /**
     * Constructor signup.
     */
    public SignupController(UserService userService) {
        this.userService = userService;
    }


    /**
     * Method get Signup.
     */
    @GetMapping("/signup")
    public String signupPage(@ModelAttribute("createUser") User user){
        return "signup";
    }


    /**
     * Method register user.
     */
    @PostMapping("/signup")
    public String signupUser(@ModelAttribute("createUser") User user, Model model, RedirectAttributes redirectAttributes) {
        String signupError = null;

        if (!userService.usernameIsAvailable(user.getUsername())) {
            signupError = "Username already exists.";
        }

        if (signupError == null) {
            int rowsAdded = userService.createUser(user);
            if (rowsAdded < 0) {
                signupError = "There was an error signing you up. Please try again.";
            }
        }

        if (signupError == null) {
            redirectAttributes.addFlashAttribute("signupSuccess", true);
            return "redirect:/login";
        } else {
            model.addAttribute("signupError", signupError);
        }


        return "signup";
    }
}
