package com.udacity.jwdnd.course1.cloudstorage.model;

/**
 * Upload files
 */
public class File {

    private Integer fileId;
    private String filename;
    private String contentType;
    private Long fileSize;
    private Integer userId;
    private byte[]fileData;

    /**
     * Constructs a new File object with specified attributes.
     *
     * @param fileId      file ID
     * @param filename    filename
     * @param contentType  contentType
     * @param userId    userId
     * @param fileData    fileData
     */
    public File(Integer fileId, String filename, String contentType, Long fileSize, Integer userId, byte[] fileData) {
        super();
        this.fileId = fileId;
        this.filename = filename;
        this.contentType = contentType;
        this.fileSize = fileSize;
        this.userId = userId;
        this.fileData = fileData;
    }

    /**
     * Get fileId
     *
     * @return fileId
     */
    public Integer getFileId() {
        return fileId;
    }

    /**
     * Sets fileId.
     *
     * @param fileId
     */
    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    /**
     * Get filename.
     *
     * @return filename
     */
    public String getFilename() {
        return filename;
    }

    /**
     * Sets filename.
     *
     * @param filename
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * Get filename
     *
     * @return filename
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * Sets contentType.
     *
     * @param contentType
     */
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    /**
     * Get fileSize.
     *
     * @return fileSize
     */
    public Long getFileSize() {
        return fileSize;
    }

    /**
     * Sets fileSize.
     *
     * @param fileSize
     */
    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * Get userId.
     *
     * @return userId
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * Sets userId.
     *
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * Get fileData
     *
     * @return fileData
     */
    public byte[] getFileData() {
        return fileData;
    }

    /**
     * Sets fileData.
     *
     * @param fileData
     */
    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }
}
