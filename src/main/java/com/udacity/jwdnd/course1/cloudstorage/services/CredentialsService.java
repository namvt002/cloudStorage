package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.CredentialsMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Credentials;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;


@Service
public class CredentialsService {
    private CredentialsMapper credentialsMapper;
    private EncryptionService encryptionService;

    public CredentialsService(CredentialsMapper credentialsMapper, EncryptionService encryptionService) {
        this.credentialsMapper = credentialsMapper;
        this.encryptionService = encryptionService;
    }

    /**
     * Retrieves a list of UserCredential
     *
     * @param userId userId
     * @return a list of UserCredential
     */
    public List<Credentials> getCredentials(int userId){
        return credentialsMapper.getCredentials(userId);
    }

    /**
     * Method create
     */
    public void addCredentials(Credentials credentials, int userId){
        SecureRandom random = new SecureRandom();
        byte[] key = new byte[16];
        random.nextBytes(key);
        String encodedKey = Base64.getEncoder().encodeToString(key);
        String encryptedPassword = encryptionService.encryptValue(credentials.getPassword(), encodedKey);

        Credentials newCredentials = new Credentials();
        newCredentials.setUrl(credentials.getUrl());
        newCredentials.setUsername(credentials.getUsername());
        newCredentials.setKey(encodedKey);
        newCredentials.setPassword(encryptedPassword);
        newCredentials.setUserId(userId);

        credentialsMapper.insertCredentilas(newCredentials);
    }

    /**
     * Method update
     *
     */
    public void editCredentials(Credentials credentials){
        Credentials storedCredential = credentialsMapper.getCredentialById(credentials.getCredentialid());

        credentials.setKey(storedCredential.getKey());
        String encryptedPassword = encryptionService.encryptValue(credentials.getPassword(), credentials.getKey());
        credentials.setPassword(encryptedPassword);
        credentialsMapper.updateCredentilas(credentials);
    }


    /**
     * Method delete
     *
     * @return ID
     */
    public int deleteCredentials(int credentialId){
        return credentialsMapper.deleteCredentilas(credentialId);
    }

}