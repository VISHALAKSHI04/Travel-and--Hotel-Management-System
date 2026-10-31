package com.travel.hotelservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travel.hotelservice.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
