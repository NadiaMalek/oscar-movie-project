package com.backbase.oscarmovie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backbase.oscarmovie.model.AverageRating;
import com.backbase.oscarmovie.model.Rating;
import com.backbase.oscarmovie.service.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	@PostMapping("/addRating")
	public ResponseEntity<Rating> saveMovieRating(@RequestBody Rating rating) throws Exception{
		return new ResponseEntity<Rating> (ratingService.saveRating(rating), HttpStatus.CREATED);
	}
	
	@GetMapping("/topRatedMovies")
	public ResponseEntity<List<AverageRating>> getTopRatedMovies() {
		return new ResponseEntity<List<AverageRating>> (ratingService.getTopRatedMovies(), HttpStatus.OK);
	}

}
