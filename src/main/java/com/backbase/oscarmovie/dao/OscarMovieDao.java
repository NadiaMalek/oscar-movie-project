package com.backbase.oscarmovie.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.backbase.oscarmovie.exception.MovieNotFoundException;
import com.backbase.oscarmovie.model.Movie;

@Repository
public interface OscarMovieDao extends CrudRepository<Movie, Integer>{

	Movie findByMovieTitle(String movie_title) throws MovieNotFoundException;
	
	List<Movie> findByOscarWonTrue();
	
	List<Movie> findByOscarWonFalse();
	
}
