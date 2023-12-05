package com.backbase.oscarmovie;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.backbase.oscarmovie.dao.OscarMovieDao;
import com.backbase.oscarmovie.model.Movie;
import com.backbase.oscarmovie.model.Rating;

@SpringBootApplication
public class OscarMovieProjectApplication implements CommandLineRunner{

	@Autowired
	OscarMovieDao oscarMovieDao;
	
	public static void main(String[] args) {
		SpringApplication.run(OscarMovieProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Movie movieObj=new Movie();
		movieObj.setAdditional_info("Nomination in 5 category");
		movieObj.setMovie_title("Black Swain");
		movieObj.setMovie_year(2010);
		movieObj.setCategory("Best Picture");
		movieObj.setOscar_won(false);
		
//		Movie movieObj2=new Movie();
//		movieObj.setAdditional_info("Kathryn Bigelow, Mark Boal, Nicolas Chartier and Greg Shapiro, Producers");
//		movieObj.setMovie_title("The Hurt Locker");
//		movieObj.setMovie_year(2009);
//		movieObj.setCategory("Best Picture");
//		movieObj.setOscar_won(true);
//		
//		Movie movieObj3=new Movie();
//		movieObj.setAdditional_info("David Hoberman, Todd Lieberman and Mark Wahlberg, Producers");
//		movieObj.setMovie_title("The Fighter");
//		movieObj.setMovie_year(2010);
//		movieObj.setCategory("Best Picture");
//		movieObj.setOscar_won(false);
		
		List<Rating> listRating=new ArrayList<Rating>();
		Rating ratingObj1=new Rating();
		ratingObj1.setRating(4);
		ratingObj1.setUser_emailId("nadiafpathan@gmial.com");
		ratingObj1.setUser_name("Nadia Pathan");
		listRating.add(ratingObj1);
		
		Rating ratingObj2=new Rating();
		ratingObj2.setRating(4);
		ratingObj2.setUser_emailId("nadiafpathan@gmial.com");
		ratingObj2.setUser_name("Nadia Pathan");
		listRating.add(ratingObj2);
		
		Rating ratingObj3=new Rating();
		ratingObj3.setRating(2);
		ratingObj3.setUser_emailId("nadiafpathan@gmial.com");
		ratingObj3.setUser_name("Nadia Pathan");
		listRating.add(ratingObj3);
		
		Rating ratingObj4=new Rating();
		ratingObj4.setRating(3);
		ratingObj4.setUser_emailId("nadiafpathan@gmial.com");
		ratingObj4.setUser_name("Nadia Pathan");
		listRating.add(ratingObj4);
		
		Rating ratingObj5=new Rating();
		ratingObj5.setRating(9);
		ratingObj5.setUser_emailId("nadiafpathan@gmial.com");
		ratingObj5.setUser_name("Nadia Pathan");
		listRating.add(ratingObj5);
		
		movieObj.setUsers_rating(listRating);
		this.oscarMovieDao.save(movieObj);
		
		Movie movieObj1=new Movie();
		movieObj1.setAdditional_info("Iain Canning, Emile Sherman and Gareth Unwin, Producers");
		movieObj1.setMovie_title("The King's Speech");
		movieObj1.setMovie_year(2010);
		movieObj1.setCategory("Best Picture");
		movieObj1.setOscar_won(true);
		
		List<Rating> listRating1=new ArrayList<Rating>();
		Rating ratingObj11=new Rating();
		ratingObj11.setRating(4);
		ratingObj11.setUser_emailId("nadiafpathan@gmial.com");
		ratingObj11.setUser_name("Nadia Pathan");
		listRating1.add(ratingObj11);
		
		Rating ratingObj12=new Rating();
		ratingObj12.setRating(4);
		ratingObj12.setUser_emailId("nadiafpathan@gmial.com");
		ratingObj12.setUser_name("Nadia Pathan");
		listRating1.add(ratingObj12);
		
		Rating ratingObj13=new Rating();
		ratingObj13.setRating(2);
		ratingObj13.setUser_emailId("nadiafpathan@gmial.com");
		ratingObj13.setUser_name("Nadia Pathan");
		listRating1.add(ratingObj13);
		
		Rating ratingObj14=new Rating();
		ratingObj14.setRating(3);
		ratingObj14.setUser_emailId("nadiafpathan@gmial.com");
		ratingObj14.setUser_name("Nadia Pathan");
		listRating1.add(ratingObj14);
		
		Rating ratingObj15=new Rating();
		ratingObj15.setRating(9);
		ratingObj15.setUser_emailId("nadiafpathan@gmial.com");
		ratingObj15.setUser_name("Nadia Pathan");
		listRating1.add(ratingObj15);
		
		movieObj1.setUsers_rating(listRating1);
		//movieObj2.setUsers_rating(listRating);
		//movieObj3.setUsers_rating(listRating);
		
		
		this.oscarMovieDao.save(movieObj1);
		//this.oscarMovieDao.save(movieObj2);
		//this.oscarMovieDao.save(movieObj3);
	}

}
