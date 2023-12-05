package com.backbase.oscarmovie.utils;

import java.util.ArrayList;
import java.util.List;

import com.backbase.oscarmovie.model.AverageRating;
import com.backbase.oscarmovie.model.Movie;
import com.backbase.oscarmovie.model.Rating;

public class TestDataGen {
	
	public static Movie getMovie() {
		Movie movieObj=new Movie();
		movieObj.setAdditional_info("Nomination in 5 category");
		movieObj.setMovieTitle("Black Swain");
		movieObj.setMovie_year(2010);
		movieObj.setCategory("Best Picture");
		movieObj.setOscarWon(false);
		return movieObj;
	}
	
	public static List<Movie> getMovieWonOscar() {
		List<Movie> movieList=new ArrayList<Movie>();
		
		Movie movieObj1=new Movie();
		movieObj1.setAdditional_info("Nomination in 5 category");
		movieObj1.setMovieTitle("Black Swain");
		movieObj1.setMovie_year(2010);
		movieObj1.setCategory("Best Picture");
		movieObj1.setOscarWon(true);
		movieList.add(movieObj1);
		
		Movie movieObj2=new Movie();
		movieObj2.setAdditional_info("Nomination in 5 category");
		movieObj2.setMovieTitle("The Fighter");
		movieObj2.setMovie_year(2010);
		movieObj2.setCategory("Best Picture");
		movieObj2.setOscarWon(true);
		movieList.add(movieObj2);
		
		return movieList;
	}
	
	public static List<Movie> getMovieDoesnotWonOscar() {
		List<Movie> movieList=new ArrayList<Movie>();
		
		Movie movieObj1=new Movie();
		movieObj1.setAdditional_info("Nomination in 5 category");
		movieObj1.setMovieTitle("Black Swain");
		movieObj1.setMovie_year(2010);
		movieObj1.setCategory("Best Picture");
		movieObj1.setOscarWon(false);
		movieList.add(movieObj1);
		
		Movie movieObj2=new Movie();
		movieObj2.setAdditional_info("Nomination in 5 category");
		movieObj2.setMovieTitle("The Fighter");
		movieObj2.setMovie_year(2010);
		movieObj2.setCategory("Best Picture");
		movieObj2.setOscarWon(false);
		movieList.add(movieObj2);
		
		return movieList;
	}
	
	public static Rating getMovieByEmailName() {
		Rating rating=new Rating();
		rating.setRating_id(1);
		rating.setRating(9.5);
		rating.setUser_name("Nadia Malek");
		rating.setEmailId("nadiafpathan@gmail.com");
		rating.setMovieName("The Fighter");
		return rating;
	}
	
	public static List<AverageRating> getListOfMovies() {
		List<AverageRating> ratingList=new ArrayList<AverageRating>();
		AverageRating rating=new AverageRating();
		rating.setAverageRating(9.5);
		rating.setMovieName("The Fighter");
		ratingList.add(rating);
		return ratingList;
	}
}
