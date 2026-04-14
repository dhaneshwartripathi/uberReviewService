package org.example.uberreviewservice.Repositories;

import org.example.uberreviewservice.Models.Booking;
import org.example.uberreviewservice.Models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, Long> {

    @Query(nativeQuery = true,value = "SELECT * FROM Driver WHERE id=:id AND license_number=:licenseNumber")// this is RAW sql query if any issue in query then error will be thrown at run time //
    Optional<Driver> rawFindByIdAndLicenseNumber(Long id,String licenseNumber);
    Optional<Driver> findByIdAndLicenseNumber(long id, String licenseNumber);

    @Query("SELECT d FROM Driver d WHERE d.id=:id AND d.licenseNumber=:ln")//this is hib ernet sql query any error is detected at compile time only
    Optional<Driver> rawFindByIdAndLicense(Long id,String ln);
}
