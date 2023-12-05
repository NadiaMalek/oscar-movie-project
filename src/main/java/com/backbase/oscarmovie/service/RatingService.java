package com.backbase.oscarmovie.service;

import java.util.List;

import com.backbase.oscarmovie.model.AverageRating;
import com.backbase.oscarmovie.model.Rating;

public interface RatingService {
	
	Rating saveRating(Rating rating) throws Exception;
	
	List<AverageRating> getTopRatedMovies();

}
