package com.example.demo.dao;

import com.example.demo.model.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryDAO implements IMyDAO {

    private List<Resort> resorts = new ArrayList<>();
    private List<Service> services = new ArrayList<>();
    private List<Tour> tours = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();

    // ===== Resorts =====
    @Override
    public void addResort(String name, String location, String type, double rating) {
        int newId = resorts.size() + 1;
        resorts.add(new Resort(newId, name, location, type, rating));
    }

    @Override
    public void updateResort(int resortId, String name, String location, String type, double rating) {
        for (Resort resort : resorts) {
            if (resort.getId() == resortId) {
                resort.setName(name);
                resort.setLocation(location);
                resort.setType(type);
                resort.setRating(rating);
            }
        }
    }

    @Override
    public void deleteResort(int resortId) {
        resorts.removeIf(resort -> resort.getId() == resortId);
    }

    @Override
    public List<Resort> searchResorts(String keyword) {
        List<Resort> result = new ArrayList<>();
        for (Resort resort : resorts) {
            if (resort.getName().contains(keyword)) {
                result.add(resort);
            }
        }
        return result;
    }

    @Override
    public List<Resort> displayAllResorts() {
        return new ArrayList<>(resorts);
    }

    // ===== Services =====
    @Override
    public void addService(String name, String description, int resortId) {
        int newId = services.size() + 1;
        services.add(new Service(newId, name, description, resortId));
    }

    @Override
    public void updateService(int serviceId, String name, String description, int resortId) {
        for (Service service : services) {
            if (service.getId() == serviceId) {
                service.setName(name);
                service.setDescription(description);
                service.setResortId(resortId);
            }
        }
    }

    @Override
    public void deleteService(int serviceId) {
        services.removeIf(service -> service.getId() == serviceId);
    }

    @Override
    public List<Service> searchServices(String keyword) {
        List<Service> result = new ArrayList<>();
        for (Service service : services) {
            if (service.getName().contains(keyword)) {
                result.add(service);
            }
        }
        return result;
    }

    @Override
    public List<Service> displayAllServices() {
        return new ArrayList<>(services);
    }

    // ===== Tours =====
    @Override
    public void addTour(String name, double price, String startDate, String endDate, int resortId) {
        int newId = tours.size() + 1;
        tours.add(new Tour(newId, name, price, startDate, endDate, resortId));
    }

    @Override
    public void updateTour(int tourId, String name, double price, String startDate, String endDate, int resortId) {
        for (Tour tour : tours) {
            if (tour.getId() == tourId) {
                tour.setName(name);
                tour.setPrice(price);
                tour.setStartDate(startDate);
                tour.setEndDate(endDate);
                tour.setResortId(resortId);
            }
        }
    }

    @Override
    public void deleteTour(int tourId) {
        tours.removeIf(tour -> tour.getId() == tourId);
    }

    @Override
    public List<Tour> searchTours(String keyword) {
        List<Tour> result = new ArrayList<>();
        for (Tour tour : tours) {
            if (tour.getName().contains(keyword)) {
                result.add(tour);
            }
        }
        return result;
    }

    @Override
    public List<Tour> displayAllTours() {
        return new ArrayList<>(tours);
    }

    // ===== Bookings =====
    @Override
    public void addBooking(String touristName, String contactInfo, int tourId, String status) {
        int newId = bookings.size() + 1;
        bookings.add(new Booking(newId, touristName, contactInfo, tourId, status));
    }

    @Override
    public void updateBooking(int bookingId, String touristName, String contactInfo, int tourId, String status) {
        for (Booking booking : bookings) {
            if (booking.getId() == bookingId) {
                booking.setTouristName(touristName);
                booking.setContactInfo(contactInfo);
                booking.setTourId(tourId);
                booking.setStatus(status);
            }
        }
    }

    @Override
    public void deleteBooking(int bookingId) {
        bookings.removeIf(booking -> booking.getId() == bookingId);
    }

    @Override
    public List<Booking> searchBookings(String keyword) {
        List<Booking> result = new ArrayList<>();
        for (Booking booking : bookings) {
            if (booking.getTouristName().contains(keyword)) {
                result.add(booking);
            }
        }
        return result;
    }

    @Override
    public List<Booking> displayAllBookings() {
        return new ArrayList<>(bookings);
    }
}
