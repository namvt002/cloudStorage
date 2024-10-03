package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import com.udacity.jwdnd.course1.cloudstorage.model.File;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.services.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Controller home.
 */
@Controller
public class HomepageController {

    private FileService fileService;
    private EncryptionService encryptionService;
    private NoteService noteService;
    private CredentialService credentialService;
    private UserService userService;

    /**
     * Constructor home.
     */
    public HomepageController(UserService userService, EncryptionService encryptionService, FileService fileService, NoteService noteService, CredentialService credentialService) {
        this.userService = userService;
        this.encryptionService = encryptionService;
        this.fileService = fileService;
        this.noteService = noteService;
        this.credentialService = credentialService;
    }

    @GetMapping("/home")
    public String homePage(Authentication authentication, Model model, File file, Note note, Credential credential) {
        User user = userService.getUser(authentication.getName());
        Integer userId = user.getUserId();

        //get list credentials
        List<Credential> credentialList = credentialService.getCredentials(userId);
        model.addAttribute("credentials", credentialList);
        model.addAttribute("encryptionService", encryptionService);

        //get list notes
        List<Note> noteList = noteService.getNotes(userId);
        model.addAttribute("notes", noteList);

        //get list files
        List<File> fileList = fileService.getFiles(userId);
        model.addAttribute("files", fileList);

        return "home";
    }
}
