package com.stud.repository;
import com.stud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    // Spring Data JPA provides all standard CRUD methods automatically (save, findAll, findById, delete)
    
}