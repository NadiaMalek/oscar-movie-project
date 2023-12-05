package com.backbase.oscarmovie.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tbl_movie")
public class Movie {
	
	@Id
	@Column(name="movie_id")
	@SequenceGenerator(name="movie_generator", sequenceName="tbl_movie_seq", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="movie_generator")
	private Integer movie_id;
	
	@Column(name="category")
	private String Category;
	
	@Column(name = "movie_title")
	@NotBlank(message = "Movie title shouldn't be blank or empty. Please enter the Movie Title.")
	private String movieTitle;
	
	@Column(name = "movie_year")
	private Integer movie_year;
	
	@Column(name = "additional_info")
	private String additional_info;

	@Column(name = "oscar_won")
	private boolean oscarWon;

	public Integer getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(Integer movie_id) {
		this.movie_id = movie_id;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public Integer getMovie_year() {
		return movie_year;
	}

	public void setMovie_year(Integer movie_year) {
		this.movie_year = movie_year;
	}

	public String getAdditional_info() {
		return additional_info;
	}

	public void setAdditional_info(String additional_info) {
		this.additional_info = additional_info;
	}

	public boolean isOscarWon() {
		return oscarWon;
	}

	public void setOscarWon(boolean oscarWon) {
		this.oscarWon = oscarWon;
	}

	@Override
	public String toString() {
		return "Movie [movie_id=" + movie_id + ", Category=" + Category + ", movie_title=" + movieTitle
				+ ", movie_year=" + movie_year  + ", additional_info="
				+ additional_info + ", oscar_won=" + oscarWon + "]";
	}

	public Movie(Integer movie_id, String category, String movieTitle, Integer movie_year, 
			String additional_info, boolean oscarWon) {
		super();
		this.movie_id = movie_id;
		this.Category= category;
		this.movieTitle = movieTitle;
		this.movie_year = movie_year;
		this.additional_info = additional_info;
		this.oscarWon = oscarWon;
	}

	public Movie() {}
}
