package com.example.demo.dao;

import com.example.demo.model.*;
import java.util.List;

public interface IMyDAO {

    // Resorts
    void addResort(String name, String location, String type, double rating);
    void updateResort(int resortId, String name, String location, String type, double rating);
    void deleteResort(int resortId);
    List<Resort> searchResorts(String keyword);
    List<Resort> displayAllResorts();

    // Services
    void addService(String name, String description, int resortId);
    void updateService(int serviceId, String name, String description, int resortId);
    void deleteService(int serviceId);
    List<Service> searchServices(String keyword);
    List<Service> displayAllServices();

    // Tours
    void addTour(String name, double price, String startDate, String endDate, int resortId);
    void updateTour(int tourId, String name, double price, String startDate, String endDate, int resortId);
    void deleteTour(int tourId);
    List<Tour> searchTours(String keyword);
    List<Tour> displayAllTours();

    // Bookings
    void addBooking(String touristName, String contactInfo, int tourId, String status);
    void updateBooking(int bookingId, String touristName, String contactInfo, int tourId, String status);
    void deleteBooking(int bookingId);
    List<Booking> searchBookings(String keyword);
    List<Booking> displayAllBookings();
}
