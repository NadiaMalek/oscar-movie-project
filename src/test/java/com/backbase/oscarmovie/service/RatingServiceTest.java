package com.backbase.oscarmovie.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.BDDMockito.given;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.backbase.oscarmovie.OscarMovieProjectApplication;
import com.backbase.oscarmovie.dao.OscarMovieDao;
import com.backbase.oscarmovie.dao.RatingDao;
import com.backbase.oscarmovie.model.AverageRating;
import com.backbase.oscarmovie.utils.TestDataGen;

@SpringBootTest(classes = OscarMovieProjectApplication.class)
public class RatingServiceTest {

	@MockBean
	RatingDao ratingDao;
	
	@MockBean
	RatingService ratingService;
	
	@Autowired
	OscarMovieDao oscarMovieDao;
		
	@Test
	public void validMovieTitle_testFindByMovieTitle() {
		given(ratingService.getTopRatedMovies()).willReturn(TestDataGen.getListOfMovies());
		final List<AverageRating> movieRetrieved = ratingService.getTopRatedMovies();
        assertNotNull(movieRetrieved);
	}
}
