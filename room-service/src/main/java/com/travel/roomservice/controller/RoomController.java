package com.travel.roomservice.controller;

import com.travel.roomservice.entity.Room;
import com.travel.roomservice.service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    private final RoomService service;
    public RoomController(RoomService service) { this.service = service; }
    @GetMapping public List<Room> getAll() { return service.getAll(); }
    @GetMapping("/{id}") public ResponseEntity<Room> getById(@PathVariable Long id) {
        Room room = service.getById(id);
        return room == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(room);
    }
    @PostMapping public Room create(@RequestBody Room room) { return service.save(room); }
    @PutMapping("/{id}") public ResponseEntity<Room> update(@PathVariable Long id, @RequestBody Room room) {
        Room updated = service.update(id, room);
        return updated == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(updated);
    }
    @DeleteMapping("/{id}") public ResponseEntity<String> delete(@PathVariable Long id) {
        return service.delete(id) ? ResponseEntity.ok("Room deleted successfully") : ResponseEntity.notFound().build();
    }
}
