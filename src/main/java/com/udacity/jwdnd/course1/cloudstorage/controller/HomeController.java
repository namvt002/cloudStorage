package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.services.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller home.
 */
@Controller
public class HomeController {

    private FileService fileService;
    private NoteService noteService;
    private CredentialsService credentialsService;
    private UserMapper userMapper;
    private EncryptionService encryptionService;

    /**
     * Constructor home.
     */
    public HomeController(FileService fileService, NoteService noteService, CredentialsService credentialsService, UserMapper userMapper, EncryptionService encryptionService) {
        this.fileService = fileService;
        this.noteService = noteService;
        this.userMapper = userMapper;
        this.credentialsService = credentialsService;
        this.encryptionService = encryptionService;
    }

    @GetMapping("/result")
    public String result(){
        return "result";
    }

    @GetMapping("/home")
    public String home(Authentication authentication, Model model) {

        String loggedInUserName = (String) authentication.getPrincipal();
        User user = userMapper.getUser(loggedInUserName);

        //get list files
        model.addAttribute("files", fileService.getUploadedFiles(user.getUserId()));
        //get list notes
        model.addAttribute("notes", noteService.getNotes(user.getUserId()));
        //get list credentials
        model.addAttribute("credentials", credentialsService.getCredentials(user.getUserId()));
        model.addAttribute("encryptionService", encryptionService);

        return "home";
    }

}