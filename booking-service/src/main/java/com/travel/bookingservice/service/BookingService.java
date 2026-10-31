package com.travel.bookingservice.service;

import com.travel.bookingservice.entity.Booking;
import com.travel.bookingservice.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository repository;

    public BookingService(BookingRepository repository) {
        this.repository = repository;
    }

    public Booking createBooking(Booking booking) {
        booking.setStatus("PENDING");
        return repository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return repository.findAll();
    }

    public Booking getBooking(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found: " + id));
    }

    public List<Booking> getBookingsByUser(Long userId) {
        return repository.findByUserId(userId);
    }

    public List<Booking> getPendingBookings() {
        return repository.findByStatus("PENDING");
    }

    public Booking confirmBooking(Long id) {
        Booking booking = getBooking(id);
        booking.setStatus("CONFIRMED");
        return repository.save(booking);
    }

    public Booking rejectBooking(Long id) {
        Booking booking = getBooking(id);
        booking.setStatus("REJECTED");
        return repository.save(booking);
    }
}
