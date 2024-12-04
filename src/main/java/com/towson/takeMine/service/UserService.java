
package com.towson.takeMine.service;

import com.towson.takeMine.entity.User;
import com.towson.takeMine.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {
        if (userRepository.findByTuEmail(user.getTuEmail()) != null) {
            throw new IllegalArgumentException("Email already exists");
        }
        return userRepository.save(user);
    }

    public String authenticateUser(String email, String password) {
        Optional<User> user = Optional.ofNullable(userRepository.findByTuEmail(email));
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return "Authentication successful";
        } else {
            throw new IllegalArgumentException("Invalid credentials");
        }
    }

    public User updateUserProfile(String userId, User updates) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
//        if (updates.getName() != null) user.setName(updates.getName());
//        if (updates.getAddress() != null) user.setAddress(updates.getAddress());
//        if (updates.getPhone() != null) user.setPhone(updates.getPhone());
//        // Apply other updates similarly
        return userRepository.save(updates);
    }

    public void resetPassword(String email, String newPassword) {
        User user = userRepository.findByTuEmail(email);
        if (user == null) {
            throw new IllegalArgumentException("Email not registered");
        }
        user.setPassword(newPassword);
        userRepository.save(user);
    }

    public Double getMyBalance(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
        return user.getBalance();
    }

    public User getUserProfile(String userId) {
        return userRepository.findById(userId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
