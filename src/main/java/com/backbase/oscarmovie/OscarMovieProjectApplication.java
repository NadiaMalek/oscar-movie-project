package com.backbase.oscarmovie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.backbase.oscarmovie.dao.OscarMovieDao;

@SpringBootApplication
public class OscarMovieProjectApplication {

	@Autowired
	OscarMovieDao oscarMovieDao;
	
	public static void main(String[] args) {
		SpringApplication.run(OscarMovieProjectApplication.class, args);
	}
}
