package com.travel.roomservice.service;

import com.travel.roomservice.entity.Room;
import com.travel.roomservice.repository.RoomRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoomService {
    private final RoomRepository repository;
    public RoomService(RoomRepository repository) { this.repository = repository; }
    public List<Room> getAll() { return repository.findAll(); }
    public Room getById(Long id) { return repository.findById(id).orElse(null); }
    public Room save(Room room) { return repository.save(room); }
    public Room update(Long id, Room room) {
        Room existing = repository.findById(id).orElse(null);
        if (existing == null) return null;
        existing.setRoomNumber(room.getRoomNumber());
        existing.setRoomType(room.getRoomType());
        existing.setPrice(room.getPrice());
        existing.setAvailable(room.isAvailable());
        return repository.save(existing);
    }
    public boolean delete(Long id) {
        if (!repository.existsById(id)) return false;
        repository.deleteById(id);
        return true;
    }
}
