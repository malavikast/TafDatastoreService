package com.tekarch.flights.TafDatastoreService.Repositories;

import com.tekarch.flights.TafDatastoreService.Models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}
