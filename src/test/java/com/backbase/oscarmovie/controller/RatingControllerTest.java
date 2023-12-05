package com.backbase.oscarmovie.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.backbase.oscarmovie.OscarMovieProjectApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OscarMovieProjectApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RatingControllerTest {
	@LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();
    public static final String CLIENT_NAME="0oaah7ng7jNEEWosu5d7";
    public static final String CLIENT_PASSWORD="GA93MmjAUXSfUU69__bWJqXGOq9lnO6jeAYRGmM5ayPeyM5p9rBBSylndNgHSRDC";		


    @Before
    public void setUp() {
        headers.setContentType(MediaType.APPLICATION_JSON);
    }
    @Test
    public void collectionGet_noAuth_returnsUnauthorized() throws Exception {
    	MultiValueMap<String, String> request = new LinkedMultiValueMap<String, String>();
        request.set("username", "username");
        request.set("password", "oassword");
        request.set("grant_type", "client_credentials");
        @SuppressWarnings("unchecked")
        Map<String, Object> token = new TestRestTemplate(CLIENT_NAME, CLIENT_PASSWORD)
            .postForObject("https://dev-47097885.okta.com/oauth2/default/v1/token", request, Map.class);
        assertNotNull("Wrong response: " + token, token.get("access_token"));    
    }
    
    @Test
    public void validURL_shouldReturnWith401() {
    	headers.setBearerAuth(generateInvalidAccessToken());
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<?> response = restTemplate.exchange(createURLWithPort("/rating/topRatedMovies"), HttpMethod.GET, entity, String.class);
        assertEquals(401, response.getStatusCode().value());
    }
    @Test
    public void TopRatedValidurl_shouldReturnWith200() {
    	headers.setBearerAuth(generateAccessToken());
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<?> response = restTemplate.exchange(createURLWithPort("/rating/topRatedMovies"), HttpMethod.GET, entity, String.class);
        assertEquals(200, response.getStatusCode().value());
   }
    
   private String generateAccessToken() {
    	MultiValueMap<String, String> request = new LinkedMultiValueMap<String, String>();
        request.set("username", "0oaah7ng7jNEEWosu5d7");
        request.set("password", "GA93MmjAUXSfUU69__bWJqXGOq9lnO6jeAYRGmM5ayPeyM5p9rBBSylndNgHSRDC");
        request.set("grant_type", "client_credentials");
        request.set("scope", "oscar_code");
        @SuppressWarnings("unchecked")
		Map<String, String> token = new TestRestTemplate(CLIENT_NAME, CLIENT_PASSWORD).postForObject("https://dev-47097885.okta.com/oauth2/default/v1/token", request, Map.class);
    	return token.get("access_token").toString();
    }
    
    private String generateInvalidAccessToken() {
    	MultiValueMap<String, String> request = new LinkedMultiValueMap<String, String>();
        request.set("username", "username");
        request.set("password", "oassword");
        request.set("grant_type", "client_credentials");
        @SuppressWarnings("unchecked")
        Map<String, Object> token = new TestRestTemplate(CLIENT_NAME, CLIENT_PASSWORD)
            .postForObject("https://dev-47097885.okta.com/oauth2/default/v1/token", request, Map.class);
        return token.toString();
    } 
   private URI createURLWithPort(String uri) {
        return URI.create("http://localhost:" + port + uri);
   } 
}
