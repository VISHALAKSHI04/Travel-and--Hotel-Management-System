package com.travel.hotelservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.travel.hotelservice.entity.Hotel;
import com.travel.hotelservice.repository.HotelRepository;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    // CREATE
    public Hotel saveHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    // READ - All
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    // READ - By ID
    public Hotel getHotelById(Long id) {
        return hotelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hotel not found with id: " + id));
    }

    // UPDATE
    public Hotel updateHotel(Long id, Hotel hotel) {

        Hotel existingHotel = hotelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hotel not found with id: " + id));

        existingHotel.setName(hotel.getName());
        existingHotel.setLocation(hotel.getLocation());
        existingHotel.setType(hotel.getType());
        existingHotel.setPricePerNight(hotel.getPricePerNight());

        return hotelRepository.save(existingHotel);
    }

    // DELETE
    public void deleteHotel(Long id) {

        if (!hotelRepository.existsById(id)) {
            throw new RuntimeException("Hotel not found with id: " + id);
        }

        hotelRepository.deleteById(id);
    }
}
