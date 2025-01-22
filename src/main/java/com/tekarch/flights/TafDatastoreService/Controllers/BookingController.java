package com.tekarch.flights.TafDatastoreService.Controllers;

import com.tekarch.flights.TafDatastoreService.Models.Booking;
import com.tekarch.flights.TafDatastoreService.Repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    // Create booking
    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        booking.setCreatedAt(LocalDateTime.now());
        booking.setUpdatedAt(LocalDateTime.now());

        Booking savedBooking= bookingRepository.save(booking);
        return savedBooking;
    }

    // Get booking by ID
    @GetMapping("/{id}")
    public Booking getBooking(@PathVariable Long id) {
        return bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking not found"));
    }

     //Get booking by User ID
    @GetMapping("/user/{userId}")
    public List<Booking> getBookingByUserId(@PathVariable Long userId) {
        return bookingRepository.findBookingsByUserId(userId);

    }

    // Get all bookings
    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    // Delete booking
    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable Long id) {
        Booking booking = bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking Id not found"));

        booking.setStatus("Cancelled");
        booking.setUpdatedAt(LocalDateTime.now());
        bookingRepository.save(booking);
    }

}