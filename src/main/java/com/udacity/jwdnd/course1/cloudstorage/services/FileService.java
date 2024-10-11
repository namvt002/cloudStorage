package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.FileMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.File;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class FileService {
    private final FileMapper fileMapper;

    public FileService(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }

    public void addFile(MultipartFile fileUpload, int userid) throws IOException {
        File file = new File();
        try {
            file.setContenttype(fileUpload.getContentType());
            file.setFiledata(fileUpload.getBytes());
            file.setFilename(fileUpload.getOriginalFilename());
            file.setFilesize(Long.toString(fileUpload.getSize()));
            file.setUserid(userid);
        } catch (IOException e) {
            throw e;
        }
        fileMapper.storeFile(file);
    }

    /**
     * Get userId
     *
     * @return List File
     */
    public List<File> getUploadedFiles(Integer userId){
        return fileMapper.getAllFiles(userId);
    }

    /**
     * Get fileId
     *
     * @return a File
     */
    public File getFileById(Integer fileId){
        return fileMapper.getFileById(fileId);
    }

    /**
     * Check file is Available
     *
     * @return true if getFile else return false
     */
    public boolean isFileAvailable(String filename, Integer userid) {
        File file = fileMapper.getFile(userid, filename);

        if(file != null) {
            return false;
        }

        return true;
    }

    /**
     * deleteFile
     *
     * @return fileId
     */
    public int deleteFile(int fileId) {
        return fileMapper.deleteFile(fileId);
    }

}
