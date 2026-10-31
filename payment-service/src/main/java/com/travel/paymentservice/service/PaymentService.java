package com.travel.paymentservice.service;

import com.travel.paymentservice.entity.Payment;
import com.travel.paymentservice.repository.PaymentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PaymentService {
    private final PaymentRepository repository;
    public PaymentService(PaymentRepository repository) { this.repository = repository; }
    public List<Payment> getAll() { return repository.findAll(); }
    public Payment getById(Long id) { return repository.findById(id).orElse(null); }
    public Payment save(Payment payment) { return repository.save(payment); }
    public Payment update(Long id, Payment payment) {
        Payment existing = repository.findById(id).orElse(null);
        if (existing == null) return null;
        existing.setUserId(payment.getUserId());
        existing.setBookingId(payment.getBookingId());
        existing.setAmount(payment.getAmount());
        existing.setPaymentMethod(payment.getPaymentMethod());
        existing.setPaymentStatus(payment.getPaymentStatus());
        return repository.save(existing);
    }
    public boolean delete(Long id) {
        if (!repository.existsById(id)) return false;
        repository.deleteById(id);
        return true;
    }
}
