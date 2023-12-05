package com.backbase.oscarmovie.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.backbase.oscarmovie.dao.UserDao;
import com.backbase.oscarmovie.model.CustomUserDetails;
import com.backbase.oscarmovie.model.User;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<User> dbUserData=userDao.findByFirstName(userName);
		dbUserData.orElseThrow(()-> new UsernameNotFoundException("User not found in the database"));
		return dbUserData.map(CustomUserDetails::new).get();
	}

}
