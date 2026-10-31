package com.travel.paymentservice.controller;

import com.travel.paymentservice.entity.Payment;
import com.travel.paymentservice.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private final PaymentService service;
    public PaymentController(PaymentService service) { this.service = service; }
    @GetMapping public List<Payment> getAll() { return service.getAll(); }
    @GetMapping("/{id}") public ResponseEntity<Payment> getById(@PathVariable Long id) {
        Payment p = service.getById(id);
        return p == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(p);
    }
    @PostMapping public Payment create(@RequestBody Payment payment) { return service.save(payment); }
    @PutMapping("/{id}") public ResponseEntity<Payment> update(@PathVariable Long id, @RequestBody Payment payment) {
        Payment p = service.update(id, payment);
        return p == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(p);
    }
    @DeleteMapping("/{id}") public ResponseEntity<String> delete(@PathVariable Long id) {
        return service.delete(id) ? ResponseEntity.ok("Payment deleted successfully") : ResponseEntity.notFound().build();
    }
}
