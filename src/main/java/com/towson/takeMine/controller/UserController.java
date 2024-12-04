
package com.towson.takeMine.controller;


import com.towson.takeMine.entity.User;
import com.towson.takeMine.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        System.out.println(user.toString() + "..........");
        return ResponseEntity.ok(userService.registerUser(user));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticateUser(@RequestParam String email, @RequestParam String password) {
        return ResponseEntity.ok(userService.authenticateUser(email, password));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUserProfile(@PathVariable String userId, @RequestBody User updates) {
        return ResponseEntity.ok(userService.updateUserProfile(userId, updates));
    }

    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestParam String email, @RequestParam String newPassword) {
        userService.resetPassword(email, newPassword);
        return ResponseEntity.ok("Password reset successfully");
    }

    @GetMapping("/{userId}/balance")
    public ResponseEntity<Double> getMyBalance(@PathVariable String userId) {
        return ResponseEntity.ok(userService.getMyBalance(userId));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserProfile(@PathVariable String userId) {
        return ResponseEntity.ok(userService.getUserProfile(userId));
    }
}
