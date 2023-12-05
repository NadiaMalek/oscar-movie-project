package com.backbase.oscarmovie.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.backbase.oscarmovie.OscarMovieProjectApplication;
import com.backbase.oscarmovie.dao.OscarMovieDao;
import com.backbase.oscarmovie.exception.MovieNotFoundException;
import com.backbase.oscarmovie.model.Movie;
import com.backbase.oscarmovie.utils.TestDataGen;

@SpringBootTest(classes = OscarMovieProjectApplication.class)
public class MovieServiceTest {
	
	@MockBean
	private OscarMovieDao oscarMovieDao;

	@Autowired
	private MovieService movieService;
	
	@Test
	public void validMovieTitle_testFindByMovieTitle() {
		given(oscarMovieDao.findByMovieTitle("Black Swain")).willReturn(TestDataGen.getMovie());
        final Movie movieRetrieved = movieService.getMovieByTitle("Black Swain");
        assertEquals(movieRetrieved.getMovieTitle(), TestDataGen.getMovie().getMovieTitle());
        assertNotNull(movieRetrieved);
	}
	
	@Test
	public void inValidMovieTitle_testFindByMovieTitle() {
		when(oscarMovieDao.findByMovieTitle("The Fighter")).thenThrow(MovieNotFoundException.class);
        assertThrows(MovieNotFoundException.class, () -> movieService.getMovieByTitle("The Fighter"));
	}
	
	@Test
	public void testfindByOscarWonTrue() {
		given(oscarMovieDao.findByOscarWonTrue()).willReturn(TestDataGen.getMovieWonOscar());
        final List<Movie> movieRetrieved = movieService.getAllMovieWinOscar();
        assertEquals(movieRetrieved.size(), TestDataGen.getMovieWonOscar().size());
	}
	
	@Test
	public void testfindByOscarWonFalse() {
		given(oscarMovieDao.findByOscarWonFalse()).willReturn(TestDataGen.getMovieDoesnotWonOscar());
        final List<Movie> movieRetrieved = movieService.getAllMovieNotWinOscar();
        assertEquals(movieRetrieved.size(), TestDataGen.getMovieDoesnotWonOscar().size());
	}
	
	@Test
	public void testGetAllMovies() {
		given(oscarMovieDao.findByOscarWonFalse()).willReturn(TestDataGen.getMovieDoesnotWonOscar());
        final List<Movie> movieRetrieved = movieService.getAllMovieNotWinOscar();
        assertEquals(movieRetrieved.size(), TestDataGen.getMovieDoesnotWonOscar().size());
	}
	
}