package com.travel.notificationservice.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.travel.notificationservice.entity.Notification;
import com.travel.notificationservice.repository.NotificationRepository;

@Service
public class Notificationservice {
    private final NotificationRepository notificationRepository;

    public Notificationservice(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public List<Notification> getAllNotifications() { return notificationRepository.findAll(); }
    public Notification getNotificationById(Long id) { return notificationRepository.findById(id).orElse(null); }
    public List<Notification> getByUserId(Long userId) { return notificationRepository.findByUserId(userId); }
    public Notification addNotification(Notification notification) { return notificationRepository.save(notification); }
    public Notification updateNotification(Long id, Notification notification) {
        Notification existing = notificationRepository.findById(id).orElse(null);
        if (existing == null) return null;
        existing.setUserId(notification.getUserId());
        existing.setMessage(notification.getMessage());
        existing.setType(notification.getType());
        existing.setReadStatus(notification.isReadStatus());
        return notificationRepository.save(existing);
    }
    public boolean deleteNotification(Long id) {
        if (!notificationRepository.existsById(id)) return false;
        notificationRepository.deleteById(id);
        return true;
    }
}
