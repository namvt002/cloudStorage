package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Base64;

@Component
public class UserService {
    private UserMapper userMapper;
    private HashService hashService;

    public UserService(UserMapper userMapper, HashService hashService) {
        this.userMapper = userMapper;
        this.hashService = hashService;
    }

    /**
     * Get User
     *
     * @return username
     */

    public User getUser(String username) {
        return userMapper.getUser(username);
    }

    /**
     * Checks username is available.
     *
     * @param username username to check
     * @return true is available else false
     */
    public boolean usernameIsAvailable(String username) {
        return userMapper.getUser(username) == null;
    }
    public Integer createUser(User userModel) {

        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        //Encoder
        String encodeSalt = Base64.getEncoder().encodeToString(salt);

        String hashedPassword = hashService.getHashedValue(userModel.getPassword(), encodeSalt);
        userModel.setSalt(encodeSalt);
        userModel.setPassword(hashedPassword);

        return userMapper.create(userModel);
    }
}
