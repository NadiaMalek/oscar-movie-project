package com.backbase.oscarmovie.service;

import java.util.List;

import com.backbase.oscarmovie.exception.MovieNotFoundException;
import com.backbase.oscarmovie.model.Movie;

public interface MovieService {

	Iterable<Movie> getAllMovies();
	
	Movie getMovieByTitle(String movie_title) throws MovieNotFoundException;
	
	List<Movie> getAllMovieWinOscar();
	
	List<Movie> getAllMovieNotWinOscar();
	
	Movie addMovie(Movie movie);
}
