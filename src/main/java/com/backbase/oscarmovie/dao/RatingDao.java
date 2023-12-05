package com.backbase.oscarmovie.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.backbase.oscarmovie.model.Rating;

@Repository
public interface RatingDao extends CrudRepository<Rating, Integer> {
	
	Rating findByEmailIdAndMovieName(String emailId,String movieName);
}
