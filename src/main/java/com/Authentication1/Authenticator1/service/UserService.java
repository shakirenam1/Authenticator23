package com.Authentication1.Authenticator1.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Service
public class UserService {

    private static final Map<String, String> users = new HashMap<>();

    @Autowired
    private Environment env;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Value("${users.file.path}")
    private String usersFilePath;

    @Value("${users.user1}")
    private String user1Credentials;

    @Value("${users.user2}")
    private String user2Credentials;

    @PostConstruct
    public void init() {
        // Load users from application.properties and store in Redis
        parseAndStoreUserCredentials(user1Credentials);
        parseAndStoreUserCredentials(user2Credentials);
    }

    private void parseAndStoreUserCredentials(String credentials) {
        String[] parts = credentials.split(":");
        if (parts.length == 2) {
            users.put(parts[0], parts[1]);
            redisTemplate.opsForValue().set(parts[0], parts[1]);
        }
    }

    public boolean authenticateUser(String userId, String password) {
        // Check if the user exists and the password is correct
        String storedPassword = redisTemplate.opsForValue().get(userId);
        return storedPassword != null && storedPassword.equals(password);
    }

    public boolean signUpUser(String userId, String password) {
        if (!users.containsKey(userId)) {
            users.put(userId, password);
            redisTemplate.opsForValue().set(userId, password);
            updateUserPropertiesFile(userId, password);
            return true; // Sign-up successful
        } else {
            return false; // User already exists
        }
    }

    private void updateUserPropertiesFile(String userId, String password) {
        Properties prop = new Properties();
        OutputStream output = null;

        try {
            output = new FileOutputStream(env.getProperty("users.file.path"), true);
            prop.setProperty("users." + userId, userId + ":" + password);
            prop.store(output, null);
        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
