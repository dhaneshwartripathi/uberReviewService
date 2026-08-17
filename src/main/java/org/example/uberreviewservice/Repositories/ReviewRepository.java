package org.example.uberreviewservice.Repositories;

import org.example.uberreviewservice.Models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
 // during runtime all the implementation/methods of the JpaRepository
// linked to review will automatically get created from my review repository

    Integer countAllByRatingLessThanEqual(Integer givenRating);

    List<Review> findAllByRatingLessThanEqual(Integer givenRating);

    List<Review> findAllByCreatedAtBefore(Date givenDate);
    @Query("SELECT r FROM Booking b INNER JOIN b.review r WHERE b.id = :bookingId")
    Review findReviewByBookingId(Long bookingId);



}
