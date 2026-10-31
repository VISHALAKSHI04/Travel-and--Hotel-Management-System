package com.travel.notificationservice.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.travel.notificationservice.entity.Notification;
import com.travel.notificationservice.service.Notificationservice;

@RestController
@RequestMapping("/notifications")
public class NotificationController {
    private final Notificationservice notificationservice;
    public NotificationController(Notificationservice notificationservice) { this.notificationservice = notificationservice; }
    @GetMapping public List<Notification> getAllNotifications() { return notificationservice.getAllNotifications(); }
    @GetMapping("/{id}") public Notification getNotificationById(@PathVariable Long id) { return notificationservice.getNotificationById(id); }
    @GetMapping("/user/{userId}") public List<Notification> getByUserId(@PathVariable Long userId) { return notificationservice.getByUserId(userId); }
    @PostMapping public Notification addNotification(@RequestBody Notification notification) { return notificationservice.addNotification(notification); }
    @PutMapping("/{id}") public Notification updateNotification(@PathVariable Long id, @RequestBody Notification notification) { return notificationservice.updateNotification(id, notification); }
    @DeleteMapping("/{id}") public String deleteNotification(@PathVariable Long id) { return notificationservice.deleteNotification(id) ? "Notification deleted successfully" : "Notification not found"; }
}
