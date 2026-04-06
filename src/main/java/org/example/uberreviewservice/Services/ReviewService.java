package org.example.uberreviewservice.Services;

import org.example.uberreviewservice.Models.Booking;
import org.example.uberreviewservice.Models.Review;
import org.example.uberreviewservice.Repositories.BookingRepository;
import org.example.uberreviewservice.Repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService implements CommandLineRunner {
    private final ReviewRepository reviewRepository;

    private final BookingRepository bookingRepository ;

    public ReviewService(ReviewRepository reviewRepository, BookingRepository bookingRepository) {
        this.reviewRepository = reviewRepository;
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Review Service Started****************");

        Review r = Review.builder()
                .content("Amazing Ride")
                .rating(5.0)
                .build();//code to create plain java object

        Booking b = Booking.builder()
                .startTime(LocalDateTime.now())
                .endTime(LocalDateTime.now())
                .totalDistance(100L)
                .review(r)
                .build();
        bookingRepository.save(b);

//        Optional<Booking> b = bookingRepository.findById(6L);
//        b.ifPresent(bookingRepository::delete);


//        reviewRepository.save(r);//this code executes sql query

//        reviewRepository.deleteById(4L); //u can use all these because of JpaRepository
    }
}
