package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.FileMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.File;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileService {
    private FileMapper fileMapper;


    public FileService(FileMapper fileMapper) {
        this.fileMapper = fileMapper;

    }

    /**
     * Get fileId
     *
     * @return File
     */

    public File getFile(Integer fileId) {
        return fileMapper.getFile(fileId);
    }

    /**
     * Get list fileId
     *
     * @return List File
     */
    public List<File> getFiles(Integer userId) {
        return fileMapper.getFiles(userId);
    }


    //Check file is Available
    public boolean fileIsAvailable(Integer userId, String filename) {
        return fileMapper.getFileByName(userId, filename) == null;
    }

    public Integer uploadFile(File file) {
        return fileMapper.create(file);
    }

    public void delete(Integer fileId) {
        fileMapper.delete(fileId);
    }
}
