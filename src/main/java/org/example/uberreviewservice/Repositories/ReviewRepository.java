package org.example.uberreviewservice.Repositories;

import org.example.uberreviewservice.Models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
 // during runtime all the implementation/methods of the JpaRepository
// linked to review will automatically get created from my review repository

}
