package com.example.demo.controller;

import com.example.demo.dao.MySQLDAO;
import com.example.demo.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final MySQLDAO bookingService;

    @Autowired
    public BookingController(MySQLDAO bookingDAO) {
        this.bookingService = bookingDAO;
    }

    // Отримання всіх бронювань
    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.displayAllBookings();
    }

    // Додавання бронювання
    @PostMapping
    public String addBooking(@RequestParam String touristName, @RequestParam String contactInfo,
                             @RequestParam int tourId, @RequestParam String status) {
        bookingService.addBooking(touristName, contactInfo, tourId, status);
        return "Бронювання успішно додано!";
    }

    // Оновлення бронювання
    @PutMapping("/{bookingId}")
    public String updateBooking(@PathVariable int bookingId, @RequestParam String touristName,
                                @RequestParam String contactInfo, @RequestParam int tourId,
                                @RequestParam String status) {
        bookingService.updateBooking(bookingId, touristName, contactInfo, tourId, status);
        return "Бронювання успішно оновлено!";
    }

    // Видалення бронювання
    @DeleteMapping("/{bookingId}")
    public String deleteBooking(@PathVariable int bookingId) {
        bookingService.deleteBooking(bookingId);
        return "Бронювання успішно видалено!";
    }

    // Пошук бронювань
    @GetMapping("/search")
    public List<Booking> searchBookings(@RequestParam String keyword) {
        return bookingService.searchBookings(keyword);
    }
}
