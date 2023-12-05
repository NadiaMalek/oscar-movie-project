package com.backbase.oscarmovie.service;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backbase.oscarmovie.dao.OscarMovieDao;
import com.backbase.oscarmovie.dao.RatingDao;
import com.backbase.oscarmovie.exception.CustomEntityNotFoundException;
import com.backbase.oscarmovie.model.AverageRating;
import com.backbase.oscarmovie.model.Movie;
import com.backbase.oscarmovie.model.Rating;

@Service
public class RatingServiceImpl implements RatingService{
	
	@Autowired
	private OscarMovieDao osacarMovieDoa;
	
	@Autowired
	private RatingDao ratingDoa;

	@Override
	public Rating saveRating(Rating rating) throws Exception {
		Rating ratingResponse;
		Rating validitingRating=ratingDoa.findByEmailIdAndMovieName(rating.getEmailId(),rating.getMovieName());
		if(validitingRating!=null) {
			throw new CustomEntityNotFoundException("User with email id " +  rating.getEmailId() + " has already added the rating for the movie " + rating.getMovieName());
		} else {
			Movie movieResponse=osacarMovieDoa.findByMovieTitle(rating.getMovieName());
			ratingResponse=osacarMovieDoa.findById(movieResponse.getMovie_id()).map(movie -> {rating.setMovie(movie); return ratingDoa.save(rating);}).orElseThrow(() -> new Exception("Movie Doesnt exists"));
		}
		return ratingResponse;
	}

	@Override
	public List<AverageRating> getTopRatedMovies() {
		
		Iterable<Rating> ratingList=ratingDoa.findAll();
	    List<Rating> list=new ArrayList<Rating>();
		ratingList.forEach(list::add);
		Map<String, List<Rating>> map=list.stream().collect(Collectors.groupingBy(Rating::getMovieName, Collectors.toList()));
		
		List<AverageRating> averageRatingList = new ArrayList<AverageRating>();
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.CEILING);
		
		// Calculate average Rating for each movie and get the list of Ratings
		map.forEach((t, u)->{
			OptionalDouble optional = u.parallelStream().mapToDouble(Rating::getRating).average();
			Double averageRating = Double.valueOf(df.format(optional.getAsDouble()));
			averageRatingList.add(new AverageRating(t, averageRating));
		});
		return averageRatingList.stream().sorted(Comparator.comparing(AverageRating::getAverageRating).reversed()).limit(10).collect(Collectors.toList());
	}


}
