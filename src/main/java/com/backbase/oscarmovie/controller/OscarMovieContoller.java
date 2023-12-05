package com.backbase.oscarmovie.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backbase.oscarmovie.exception.CustomEntityNotFoundException;
import com.backbase.oscarmovie.exception.MovieNotFoundException;
import com.backbase.oscarmovie.model.Movie;
import com.backbase.oscarmovie.service.MovieService;

@RestController
@RequestMapping("/oscar")
public class OscarMovieContoller {

	@Autowired
	private MovieService movieService;

	@GetMapping("/allMovies")
	public ResponseEntity<Iterable<Movie>> getAllMovies() {
		Iterable<Movie> movieList = new ArrayList<>();
		try {
			movieList = movieService.getAllMovies();
		} catch (Exception e) {
			throw new CustomEntityNotFoundException("There are no movies found in the database......");
		}
		return ResponseEntity.ok().body(movieList);
	}

	@GetMapping("/allMovieWinOscar/{movie_title}")
	@PreAuthorize("hasAnyRole('User')")
	public ResponseEntity<Movie> getOscarDetails(@PathVariable String movie_title) {
		Movie movie=new Movie();
		try {
			movie = movieService.getMovieByTitle(movie_title);
		} catch (Exception e) {
			throw new MovieNotFoundException("No such movie found with movie title: " + movie_title);
		}
		return ResponseEntity.ok().body(movie);

	}

	@GetMapping("/allMovieWinOscar")
	@PreAuthorize("hasAnyRole('User')")
	public ResponseEntity<Iterable<Movie>> getAllMovieWinOscar() {
		List<Movie> movieList = new ArrayList<>();
		try {
			movieList = movieService.getAllMovieWinOscar();
		} catch (Exception e) {
			throw new CustomEntityNotFoundException("There are no movies who has won the oscar.....");
		}
		return ResponseEntity.ok().body(movieList);
	}

	@GetMapping("/allMovieNotWinOscar")
	@PreAuthorize("hasAnyRole('User')")
	public ResponseEntity<Iterable<Movie>> getAllMovieNotWinOscar() {
		List<Movie> movieList = new ArrayList<>();
		try {
			movieList = movieService.getAllMovieNotWinOscar();
		} catch (Exception e) {
			throw new CustomEntityNotFoundException("There are no movies who has not won the oscar.....");
		}
		return ResponseEntity.ok().body(movieList);
	}

	@PostMapping("/addMovie")
	@PreAuthorize("hasAnyRole('Admin')")
	public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
		return new ResponseEntity<Movie>(movieService.addMovie(movie), HttpStatus.CREATED);
	}
}
