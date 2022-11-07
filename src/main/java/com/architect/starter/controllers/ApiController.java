package com.architect.starter.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.architect.starter.models.MovieRating;
import com.architect.starter.repositories.MovieRatingRepository;

@Controller
@RequestMapping("/api")
public class ApiController {

	@Autowired
  private MovieRatingRepository movieRatingRepository;

  @GetMapping("/health")
	public String healthCheck() {
		return "UP";
	}

	@GetMapping("/movierating")
	public List<MovieRating> getAllMovieRatings() {
		List<MovieRating> movieRatings = new ArrayList<MovieRating>();
    movieRatingRepository.findAll().forEach(movieRatings::add);
    return movieRatings;
	}

	@GetMapping("/movierating/{id}")
	public Optional<MovieRating> getMovieRatingById(@PathVariable("id") long id) {
		return movieRatingRepository.findById(id);
	}

	@PostMapping("/movierating")
	public MovieRating saveMovieRating(@RequestBody MovieRating movieRatingUpdates) {
		return movieRatingRepository.save(movieRatingUpdates);
	}

	@PutMapping("/movierating/{id}")
	public MovieRating updateMovie(@PathVariable("id") long id, @RequestBody MovieRating newMovieRating) {
		Optional<MovieRating> movieRating = movieRatingRepository.findById(id);
		MovieRating updatedMovieRating = movieRating.get();
		updatedMovieRating.setTitle(newMovieRating.getTitle());
		updatedMovieRating.setRating(newMovieRating.getRating());
		return movieRatingRepository.save(updatedMovieRating);
	}

	@DeleteMapping("/movierating/{id}")
	public Void deleteMovieRating(@PathVariable("id") long id) {
		Optional<MovieRating> movieRating = movieRatingRepository.findById(id);
		MovieRating updatedMovieRating = movieRating.get();
		movieRatingRepository.deleteById(updatedMovieRating.getId());
		return null;
	}

}
