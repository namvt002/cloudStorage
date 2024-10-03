package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.CredentialMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CredentialService {
    private CredentialMapper credentialMapper;

    public CredentialService(CredentialMapper credentialMapper) {
        this.credentialMapper = credentialMapper;
    }

    /**
     * Retrieves a list of UserCredential
     *
     * @param userId userId
     * @return a list of UserCredential
     */
    public List<Credential> getCredentials(Integer userId) {
        return credentialMapper.getCredentials(userId);
    }

    /**
     * Get Credential
     *
     * @return ID
     */
    public Credential getCredential(Integer credentialId) {
        return credentialMapper.getCredential(credentialId);
    }


    /**
     * Method create
     *
     * @return ID
     */
    public Integer create(Credential credential) {
        return credentialMapper.create(credential);
    }

    /**
     * Method update
     *
     * @return ID
     */
    public Integer update(Credential credential) {
        return credentialMapper.update(credential);
    }

    /**
     * Method delete
     *
     */
    public void delete(Integer credentialId) {
        credentialMapper.delete(credentialId);
    }
}
