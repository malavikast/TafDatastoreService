package com.tekarch.flights.TafDatastoreService.Repositories;

import com.tekarch.flights.TafDatastoreService.Models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query("select * from tafdb.bookings b where b.user_id = ?1")
    List<Booking> findBookingsByUserId(Long userId);
}
