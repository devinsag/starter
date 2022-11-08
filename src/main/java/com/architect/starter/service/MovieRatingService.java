package com.architect.starter.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.architect.starter.model.MovieRating;
import com.architect.starter.repository.MovieRatingRepository;


@Service
public class MovieRatingService {

  @Autowired
  private MovieRatingRepository movieRatingRepository;

  public List<MovieRating> getAllMovieRatings() {
    List<MovieRating> movieRatings = new ArrayList<MovieRating>();
    movieRatingRepository.findAll().forEach(movieRatings::add);
    return movieRatings;
  }

  public MovieRating getMovieRatingById(long id) {
    Optional<MovieRating> movieRating = movieRatingRepository.findById(id);
    if (!movieRating.isPresent()) {
      return new MovieRating();
    }
    return movieRating.get();
  }

  public MovieRating saveMovieRating(MovieRating movieRating) {
    MovieRating newMovieRating = new MovieRating();
    newMovieRating.setTitle(movieRating.getTitle());
    newMovieRating.setRating(movieRating.getRating());
    return movieRatingRepository.save(newMovieRating);
  }

  public MovieRating updateMovieRating(long id, MovieRating newMovieRating) {
    MovieRating updatedMovieRating = null;
    Optional<MovieRating> movieRating = movieRatingRepository.findById(id);
    if (!movieRating.isPresent()) {
      updatedMovieRating = new MovieRating();
    } else {
      updatedMovieRating = movieRating.get();
    }
    updatedMovieRating.setTitle(newMovieRating.getTitle());
    updatedMovieRating.setRating(newMovieRating.getRating());
    return movieRatingRepository.save(updatedMovieRating);
  }

  public void deleteMovieRating(long id) {
    Optional<MovieRating> movieRating = movieRatingRepository.findById(id);
    if (!movieRating.isPresent()) {
      return;
    }
    MovieRating updatedMovieRating = movieRating.get();
    movieRatingRepository.deleteById(updatedMovieRating.getId());
  }

}
