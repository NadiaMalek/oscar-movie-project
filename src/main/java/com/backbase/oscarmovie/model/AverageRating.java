package com.backbase.oscarmovie.model;

public class AverageRating {

	private String movieName;
	
	private Double averageRating;

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public Double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(Double averageRating) {
		this.averageRating = averageRating;
	}

	public AverageRating(String movieName, Double averageRating) {
		super();
		this.movieName = movieName;
		this.averageRating = averageRating;
	}
	
	public AverageRating() {}
}
