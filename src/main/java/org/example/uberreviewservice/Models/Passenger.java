package org.example.uberreviewservice.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.springframework.http.converter.json.GsonBuilderUtils;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Passenger extends BaseModel{

    private String name;

//    private String email;

    @OneToMany(mappedBy = "passenger")
    private List<Booking> bookings  = new ArrayList<>();
}
