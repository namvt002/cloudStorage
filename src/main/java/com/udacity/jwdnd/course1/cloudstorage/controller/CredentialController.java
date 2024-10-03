package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.services.CredentialService;
import com.udacity.jwdnd.course1.cloudstorage.services.EncryptionService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.SecureRandom;
import java.util.Base64;


/**
 * Controller credentials.
 */
@Controller
public class CredentialController {

    private CredentialService credentialService;
    private UserService userService;
    private EncryptionService encryptionService;

    /**
     * Constructor credentials.
     */
    public CredentialController(CredentialService credentialService, UserService userService, EncryptionService encryptionService) {
        this.credentialService = credentialService;
        this.userService = userService;
        this.encryptionService = encryptionService;
    }

    /**
     * Method add if credentialId else update.
     */
    @PostMapping("/credentials")
    public String createOrEdit(Credential credential, Model model, Authentication authentication) {
        User currentUser = userService.getUser(authentication.getName());
        Integer userId = currentUser.getUserId();

        SecureRandom random = new SecureRandom();
        byte[] key = new byte[16];
        random.nextBytes(key);
        String encodeKey = Base64.getEncoder().encodeToString(key);
        String encryptedPassword = encryptionService.encryptValue(credential.getPassword(), encodeKey);
        credential.setKey(encodeKey);
        credential.setPassword(encryptedPassword);

        if(credential.getCredentialId() == null) {
            credential.setUserId(userId);
            credentialService.create(credential);
        } else {
            credentialService.update(credential);
        }
        model.addAttribute("success", true);
        return "redirect:/result";
    }

    /**
     * Method delete.
     */
    @GetMapping("/credentials/{credentialId}")
    public String delete(@PathVariable("credentialId") Integer credentialId) {
        credentialService.delete(credentialId);
        return "redirect:/result";
    }
}
