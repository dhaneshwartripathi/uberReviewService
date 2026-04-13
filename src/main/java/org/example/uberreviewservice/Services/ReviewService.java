package org.example.uberreviewservice.Services;

import jakarta.transaction.Transactional;
import org.example.uberreviewservice.Models.Booking;
import org.example.uberreviewservice.Models.Driver;
import org.example.uberreviewservice.Models.Review;
import org.example.uberreviewservice.Repositories.BookingRepository;
import org.example.uberreviewservice.Repositories.DriverRepository;
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
    private final DriverRepository driverRepository;

    public ReviewService(ReviewRepository reviewRepository, BookingRepository bookingRepository, DriverRepository driverRepository) {
        this.reviewRepository = reviewRepository;
        this.bookingRepository = bookingRepository;
        this.driverRepository = driverRepository;
    }
    @Transactional//Keeps session open during method execution, Lazy loading works
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Review Service Started****************");

//        Review r = Review.builder()
//                .content("Amazing Ride")
//                .rating(5.0)
//                .build();//code to create plain java object
//
//        Booking b = Booking.builder()
//                .startTime(LocalDateTime.now())
//                .endTime(LocalDateTime.now())
//                .totalDistance(100L)
//                .review(r)
//                .build();
//        bookingRepository.save(b);

//        Optional<Booking> b = bookingRepository.findById(6L);
//        b.ifPresent(bookingRepository::delete);


//        reviewRepository.save(r);//this code executes sql query

//        reviewRepository.deleteById(4L); //u can use all these because of JpaRepository


        Optional<Driver> driver = driverRepository.findById(1L);
        if(driver.isPresent()){
            System.out.println("Driver Name : "+driver.get().getName());
            List<Booking> b= driver.get().getBookings();
//            List<Booking> bookings = bookingRepository.findAllByDriver_Id(1L);
            System.out.println("Total bookings: " + b.size());
            for(Booking booking : b){
                System.out.println("ID: " + booking.getId());

            }
        }
    }
}
