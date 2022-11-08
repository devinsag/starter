package com.architect.starter.controller;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import com.architect.starter.model.MovieRating;
import com.architect.starter.repository.MovieRatingRepository;
import com.architect.starter.service.MovieRatingService;


@Controller
public class MovieRatingController {

  @Autowired
  private MovieRatingService movieRatingService;

  @RequestMapping(
    value  = "/",
    method = RequestMethod.GET
  )
  public String getIndex(Model model) {
    List<MovieRating> movieRatings = movieRatingService.getAllMovieRatings();
    model.addAttribute("movieRatings", movieRatings);
    return "index";
  }

  @RequestMapping(
    value  = "/health",
    method = RequestMethod.GET
  )
  @ResponseBody
  public ResponseEntity<String> healthCheck() {
    return ResponseEntity.ok("UP");
  }

  @RequestMapping(
    value  = "/movierating",
    method = RequestMethod.GET
  )
  @ResponseBody
  public ResponseEntity<List<MovieRating>> getAllMovieRatings() {
    List<MovieRating> movieRatings = movieRatingService.getAllMovieRatings();
    return ResponseEntity.ok(movieRatings);
  }

  @RequestMapping(
    value  = "/movierating/{id:[\\d]+}",
    method = RequestMethod.GET
  )
  @ResponseBody
  public ResponseEntity<MovieRating> getMovieRatingById(@PathVariable("id") long id) {
    MovieRating movieRating = movieRatingService.getMovieRatingById(id);
    return ResponseEntity.ok(movieRating);
  }

  @RequestMapping(
    value    = "/movierating",
    method   = RequestMethod.POST,
    consumes = "application/json",
    produces = "application/json"
  )
  @ResponseBody
  public ResponseEntity<MovieRating> saveMovieRating(@RequestBody MovieRating movieRating) {
    MovieRating newMovieRating = movieRatingService.saveMovieRating(movieRating);
    return ResponseEntity.ok(newMovieRating);
  }

  @RequestMapping(
    value 	 = "/movierating/{id:[\\d]+}",
    method   = RequestMethod.PUT,
    consumes = "application/json",
    produces = "application/json"
  )
  @ResponseBody
  public ResponseEntity<MovieRating> updateMovie(@PathVariable("id") long id, @RequestBody MovieRating newMovieRating) {
    MovieRating movieRating = movieRatingService.updateMovie(id, newMovieRating);
    return ResponseEntity.ok(movieRating);
  }

  @RequestMapping(
    value  = "/movierating/{id:[\\d]+}",
    method = RequestMethod.DELETE
  )
  @ResponseBody
  public ResponseEntity<String> deleteMovieRating(@PathVariable("id") long id) {
    movieRatingService.deleteMovieRating(id);
    return ResponseEntity.ok("OK");
  }

}
