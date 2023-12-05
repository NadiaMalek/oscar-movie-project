package com.backbase.oscarmovie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backbase.oscarmovie.dao.OscarMovieDao;
import com.backbase.oscarmovie.exception.MovieNotFoundException;
import com.backbase.oscarmovie.model.Movie;

@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private OscarMovieDao oscarMovieDao;
	
	@Override
	public Iterable<Movie> getAllMovies() {
		return oscarMovieDao.findAll();
	}

	@Override
	public Movie getMovieByTitle(String movie_title) throws MovieNotFoundException {
		return oscarMovieDao.findByMovieTitle(movie_title);
	}

	@Override
	public List<Movie> getAllMovieWinOscar() {
		return oscarMovieDao.findByOscarWonTrue();
	}

	@Override
	public List<Movie> getAllMovieNotWinOscar() {
		return oscarMovieDao.findByOscarWonFalse();
	}

	@Override
	public Movie addMovie(Movie movie) {
		return oscarMovieDao.save(movie);
	}

}
