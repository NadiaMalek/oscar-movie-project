package com.backbase.oscarmovie.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tbl_rating")
public class Rating {

	@Id
	@Column(name = "rating_id")
	@SequenceGenerator(name = "rating_generator", sequenceName = "tbl_rating_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rating_generator")
	private Integer rating_id;

	@Column(name = "rating")
	@Max(value = 10, message = "Rating should be between 0 to 10")
	@Min(value = 0, message = "Rating should be between 0 to 10")
	private Double rating;

	@Column(name = "user_name")
	@NotBlank(message = "User name is mandatory to enter. Please enter the user name...")
	private String user_name;

	@Column(name = "user_emailId")
	@Email(message = "Please enter valid email address.....")
	@NotBlank(message = "EmailId is mandatory to enter. Please enter the email id...")
	private String emailId;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "movie_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Movie movie;

	@Column(name = "movieName")
	@NotBlank(message = "Movie Name is mandatory to enter. Please enter the movie name...")
	private String movieName;

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public Integer getRating_id() {
		return rating_id;
	}

	public void setRating_id(Integer rating_id) {
		this.rating_id = rating_id;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@Override
	public String toString() {
		return "Rating [rating_id=" + rating_id + ", rating=" + rating + ", user_name=" + user_name + ", emailId="
				+ emailId + ", movie=" + movie + ", movieName=" + movieName + "]";
	}

	public Rating() {
	}

	public Rating(Integer rating_id, Double rating, String user_name, String emailId, Movie movie, String movieName) {
		this.rating_id = rating_id;
		this.rating = rating;
		this.user_name = user_name;
		this.emailId = emailId;
		this.movie = movie;
		this.movieName = movieName;
	}

	public Rating(Integer rating_id,
			@Max(value = 10, message = "Rating should be between 0 to 10") @Min(value = 0, message = "Rating should be between 0 to 10") Double rating,
			@NotBlank(message = "User name is mandatory to enter. Please enter the user name...") String user_name,
			@Email(message = "Please enter valid email address.....") @NotBlank(message = "EmailId is mandatory to enter. Please enter the email id...") String emailId,
			@NotBlank(message = "Movie Name is mandatory to enter. Please enter the movie name...") String movieName) {
		this.rating_id = rating_id;
		this.rating = rating;
		this.user_name = user_name;
		this.emailId = emailId;
		this.movieName = movieName;
	}

	public Rating(
			@Max(value = 10, message = "Rating should be between 0 to 10") @Min(value = 0, message = "Rating should be between 0 to 10") Double rating,
			@NotBlank(message = "Movie Name is mandatory to enter. Please enter the movie name...") String movieName) {
		this.rating = rating;
		this.movieName = movieName;
	}

//		public Rating(String movieName2, Double averageRating) {
//			this.movieName = movieName2;
//			this.rating=averageRating;
//		}
}
