package net.yazidi.cafee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.yazidi.cafee.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
