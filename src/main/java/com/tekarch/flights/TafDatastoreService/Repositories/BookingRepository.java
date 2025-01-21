package com.tekarch.flights.TafDatastoreService.Repositories;

import com.tekarch.flights.TafDatastoreService.Models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
