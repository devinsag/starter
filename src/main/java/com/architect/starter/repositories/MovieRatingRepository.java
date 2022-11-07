package com.architect.starter.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.architect.starter.models.MovieRating;


@Repository
public interface MovieRatingRepository extends JpaRepository<MovieRating, Long> {

}
