package com.backbase.oscarmovie.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backbase.oscarmovie.model.User;

public interface UserDao extends JpaRepository<User, Integer> {
	Optional<User> findByFirstName(String userName);
}
