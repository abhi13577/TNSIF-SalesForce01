package com.stud.model;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String type;
    
    private String password;

    // --- Constructors ---
    public User() {}
    
    // --- Getters and Setters (Essential for Spring/JPA) ---
    // You must include these methods for Spring Boot to work with your entity.
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
