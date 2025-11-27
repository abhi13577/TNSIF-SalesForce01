package com.stud.controller;

import com.stud.model.User;
import com.stud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional; 

// FIX: Setting origins to "*" temporarily allows the frontend (running on any port/file path) 
// to send all necessary CRUD methods (GET, POST, PUT, DELETE) to the backend.
@CrossOrigin(origins = "*") 
@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired 
    private UserRepository userRepository;

    // 1. READ ALL USERS (GET)
    // Endpoint: GET http://localhost:8086/api/users
    @GetMapping 
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // 2. CREATE NEW USER (POST)
    // Endpoint: POST http://localhost:8086/api/users
    @PostMapping 
    public User createUser(@RequestBody User user) {
        // In a real application, you would hash the password here (e.g., using BCrypt)
        return userRepository.save(user);
    }
    
    // 3. READ USER BY ID (GET)
    // Endpoint: GET http://localhost:8086/api/users/1
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        
        if (userOptional.isPresent()) {
            return ResponseEntity.ok(userOptional.get());
        } else {
            // Return 404 Not Found if user doesn't exist
            return ResponseEntity.notFound().build(); 
        }
    }

    // 4. UPDATE USER (PUT)
    // Endpoint: PUT http://localhost:8086/api/users/1
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        return userRepository.findById(id)
            .map(user -> {
                // Update fields from the request body
                user.setName(userDetails.getName());
                user.setType(userDetails.getType());
                // In a production app, you would ONLY update the password if a new one is provided and hash it.
                user.setPassword(userDetails.getPassword()); 
                
                User updatedUser = userRepository.save(user);
                return ResponseEntity.ok(updatedUser);
            }).orElse(ResponseEntity.notFound().build());
    }

    // 5. DELETE USER (DELETE)
    // Endpoint: DELETE http://localhost:8086/api/users/1
    @DeleteMapping("/{id}")
    // Change return type to ResponseEntity<?> to be flexible
    public ResponseEntity<?> deleteUser(@PathVariable Long id) { 
        return userRepository.findById(id)
            .map(user -> {
                userRepository.delete(user);
                // FIX: Return a 204 No Content status. 
                // This is the correct REST standard for a successful DELETE 
                // and prevents the AngularJS $http service from throwing the 'baddata' error.
                return ResponseEntity.noContent().build(); 
            }).orElse(ResponseEntity.notFound().build());
    }
}
