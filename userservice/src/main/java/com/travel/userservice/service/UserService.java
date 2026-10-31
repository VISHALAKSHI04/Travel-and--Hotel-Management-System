package com.travel.userservice.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.travel.userservice.entity.User;
import com.travel.userservice.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) { this.userRepository = userRepository; }
    public User saveUser(User user) { return userRepository.save(user); }
    public List<User> getAllUsers() { return userRepository.findAll(); }
    public User getUserById(Long id) { return userRepository.findById(id).orElse(null); }
    public User updateUser(Long id, User user) {
        User existing = userRepository.findById(id).orElse(null);
        if (existing == null) return null;
        existing.setName(user.getName()); existing.setEmail(user.getEmail());
        existing.setPhone(user.getPhone()); existing.setPassword(user.getPassword());
        return userRepository.save(existing);
    }
    public void deleteUser(Long id) { userRepository.deleteById(id); }
}
