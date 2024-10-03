package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.File;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.services.FileService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.unit.DataSize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Controller File.
 */
@Controller
public class FileController {

    private FileService fileService;
    private UserService userService;

    /**
     * Constructor File.
     */
    public FileController(FileService fileService, UserService userService) {
        this.fileService = fileService;
        this.userService = userService;
    }

    /**
     * Method add file.
     */
    @PostMapping("/files")
    public String fileUpload(@RequestParam("fileUpload")MultipartFile multipartFile, Model model, Authentication authentication) throws IOException {
        User userModel = userService.getUser(authentication.getName());
        Integer userId = userModel.getUserId();
        String filename = multipartFile.getOriginalFilename();

        if (!fileService.fileIsAvailable(userId, filename)) {
            model.addAttribute("success", false);
            model.addAttribute("error", "FILE ALREADY.");
            return "result";
        } else {
            String contentType = multipartFile.getContentType();
            Long fileSize = multipartFile.getSize();
            byte[] fileData = multipartFile.getBytes();

            if(multipartFile.getSize()  <= maximumFileSize.toBytes()) {
                fileService.uploadFile(new File(null, filename, contentType, fileSize, userId, fileData ));
                model.addAttribute("success", true);
            }
            return "result";
        }
    }

    /**
     * Method get File.
     */
    @GetMapping("/files/{fileId}")
    public String deleteFile(@PathVariable("fileId") Integer fileId) {
        fileService.delete(fileId);
        return "redirect:/result";
    }

    @Autowired
    @Value("${files.max-file-size}")
    private DataSize maximumFileSize;

    /**
     * Method view File.
     */
    @GetMapping("/files/view/{fileId}")
    public void viewFile(@PathVariable("fileId") Integer fileId, HttpServletResponse response, Authentication authentication) throws IOException {
        User currentUser = userService.getUser(authentication.getName());
        File file = fileService.getFile(fileId);

        response.setContentType(file.getContentType());
        response.setHeader("Content-Disposition", "filename=\"" + file.getFilename() + "\"");
        response.setContentLengthLong(file.getFileSize());

        OutputStream ops = response.getOutputStream();
        try {
            ops.write(file.getFileData(), 0, file.getFileData().length);
        } catch (Exception e) {

        } finally {
            ops.close();
        }
    }

}
