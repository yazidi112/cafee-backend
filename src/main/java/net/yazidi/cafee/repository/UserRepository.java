package net.yazidi.cafee.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import net.yazidi.cafee.entity.User;

import java.util.Optional;

// Defines a repository which provides an API or a list of helpful functions
// that helps us to work with the User entity
public interface UserRepository extends JpaRepository<User, Long> {
    // Defines a custom method to find a User using the email attribute
    public Optional<User> findByEmail(String email);
}
