package com.udacity.jwdnd.course1.cloudstorage.model;

/**
 * Store credentials for specific websites
 */
public class Credential {

    private Integer credentialId;
    private String url;
    private String username;
    private String key;
    private String password;
    private Integer userId;

    /**
     * Constructs a Credential object without userId.
     *
     * @param credentialId ID
     * @param url          URL
     * @param username     username
     * @param key          encryption key
     * @param password     password
     */
    public Credential(Integer credentialId, String url, String username, String key, String password, Integer userId) {
        this.credentialId = credentialId;
        this.url = url;
        this.username = username;
        this.key = key;
        this.password = password;
        this.userId = userId;
    }

    /**
     * Get ID
     *
     * @return ID
     */
    public Integer getCredentialId() {
        return credentialId;
    }

    /**
     * Sets credential ID.
     *
     * @param credentialId credential ID
     */
    public void setCredentialId(Integer credentialId) {
        this.credentialId = credentialId;
    }

    /**
     * Get url
     *
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets url.
     *
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Get Username
     *
     * @return Username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets Username.
     *
     * @param username Username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets Key.
     *
     * @return Key
     */
    public String getKey() {
        return key;
    }

    /**
     * Sets key.
     *
     * @param key
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Get password
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Get password
     *
     * @return password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get userId
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
}
