package com.tekarch.flights.TafDatastoreService.Repositories;

import com.tekarch.flights.TafDatastoreService.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
