package org.example.uberreviewservice.Models;


import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking extends BaseModel {

    @OneToOne (cascade = {CascadeType.PERSIST,CascadeType.REMOVE}) // We have defined a 1:1 relationship between booking and review;
    private Review review;

    @Enumerated(value = EnumType.STRING )
    private BookingStatus bookingStatus;

//    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime startTime;

//    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime endTime;

    private Long totalDistance;

    @ManyToOne
    private Driver driver;

    @ManyToOne
    private Passenger passenger;

}
