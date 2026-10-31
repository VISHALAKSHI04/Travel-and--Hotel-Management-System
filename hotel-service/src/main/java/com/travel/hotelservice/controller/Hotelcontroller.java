package com.travel.hotelservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.travel.hotelservice.entity.Hotel;
import com.travel.hotelservice.service.HotelService;

@RestController
public class Hotelcontroller {

    private final HotelService hotelService;

    public Hotelcontroller(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    // CREATE
    @PostMapping("/hotels")
    public Hotel saveHotel(@RequestBody Hotel hotel) {
        return hotelService.saveHotel(hotel);
    }

    // READ - All Hotels
    @GetMapping("/hotels")
    public List<Hotel> getAllHotels() {
        return hotelService.getAllHotels();
    }

    // READ - Hotel by ID
    @GetMapping("/hotels/{id}")
    public Hotel getHotelById(@PathVariable Long id) {
        return hotelService.getHotelById(id);
    }

    // UPDATE
    @PutMapping("/hotels/{id}")
    public Hotel updateHotel(
            @PathVariable Long id,
            @RequestBody Hotel hotel) {

        return hotelService.updateHotel(id, hotel);
    }

    // DELETE
    @DeleteMapping("/hotels/{id}")
    public String deleteHotel(@PathVariable Long id) {

        hotelService.deleteHotel(id);

        return "Hotel deleted successfully";
    }
}
