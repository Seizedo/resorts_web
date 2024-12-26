package com.example.demo.dao;

import com.example.demo.model.*;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MySQLDAO implements IMyDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/Curort1";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // ===== Resorts =====
    @Override
    public void addResort(String name, String location, String type, double rating) {
        String sql = "INSERT INTO Resorts (Name, Location, Type, Rating) VALUES (?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, location);
            stmt.setString(3, type);
            stmt.setDouble(4, rating);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error adding resort: " + e.getMessage(), e);
        }
    }

    @Override
    public void updateResort(int resortId, String name, String location, String type, double rating) {
        String sql = "UPDATE Resorts SET Name = ?, Location = ?, Type = ?, Rating = ? WHERE ResortID = ?";
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, location);
            stmt.setString(3, type);
            stmt.setDouble(4, rating);
            stmt.setInt(5, resortId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating resort: " + e.getMessage(), e);
        }
    }

    @Override
    public void deleteResort(int resortId) {
        String sql = "DELETE FROM Resorts WHERE ResortID = ?";
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, resortId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting resort: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Resort> searchResorts(String keyword) {
        String sql = "SELECT * FROM Resorts WHERE Name LIKE ?";
        List<Resort> resorts = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, "%" + keyword + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                resorts.add(new Resort(
                        rs.getInt("ResortID"),
                        rs.getString("Name"),
                        rs.getString("Location"),
                        rs.getString("Type"),
                        rs.getDouble("Rating")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error searching resorts: " + e.getMessage(), e);
        }
        return resorts;
    }

    @Override
    public List<Resort> displayAllResorts() {
        String sql = "SELECT * FROM Resorts";
        List<Resort> resorts = new ArrayList<>();
        try (Connection connection = getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                resorts.add(new Resort(
                        rs.getInt("ResortID"),
                        rs.getString("Name"),
                        rs.getString("Location"),
                        rs.getString("Type"),
                        rs.getDouble("Rating")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all resorts: " + e.getMessage(), e);
        }
        return resorts;
    }

    // ===== Services =====
    @Override
    public void addService(String name, String description, int resortId) {
        String sql = "INSERT INTO Services (Name, Description, ResortID) VALUES (?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, description);
            stmt.setInt(3, resortId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error adding service: " + e.getMessage(), e);
        }
    }

    @Override
    public void updateService(int serviceId, String name, String description, int resortId) {
        String sql = "UPDATE Services SET Name = ?, Description = ?, ResortID = ? WHERE ServiceID = ?";
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, description);
            stmt.setInt(3, resortId);
            stmt.setInt(4, serviceId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating service: " + e.getMessage(), e);
        }
    }

    @Override
    public void deleteService(int serviceId) {
        String sql = "DELETE FROM Services WHERE ServiceID = ?";
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, serviceId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting service: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Service> searchServices(String keyword) {
        String sql = "SELECT * FROM Services WHERE Name LIKE ?";
        List<Service> services = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, "%" + keyword + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                services.add(new Service(
                        rs.getInt("ServiceID"),
                        rs.getString("Name"),
                        rs.getString("Description"),
                        rs.getInt("ResortID")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error searching services: " + e.getMessage(), e);
        }
        return services;
    }

    @Override
    public List<Service> displayAllServices() {
        String sql = "SELECT * FROM Services";
        List<Service> services = new ArrayList<>();
        try (Connection connection = getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                services.add(new Service(
                        rs.getInt("ServiceID"),
                        rs.getString("Name"),
                        rs.getString("Description"),
                        rs.getInt("ResortID")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all services: " + e.getMessage(), e);
        }
        return services;
    }

    // ===== Tours =====
    @Override
    public void addTour(String name, double price, String startDate, String endDate, int resortId) {
        String sql = "INSERT INTO Tours (Name, Price, StartDate, EndDate, ResortID) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setDouble(2, price);
            stmt.setDate(3, Date.valueOf(startDate));
            stmt.setDate(4, Date.valueOf(endDate));
            stmt.setInt(5, resortId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error adding tour: " + e.getMessage(), e);
        }
    }

    @Override
    public void updateTour(int tourId, String name, double price, String startDate, String endDate, int resortId) {
        String sql = "UPDATE Tours SET Name = ?, Price = ?, StartDate = ?, EndDate = ?, ResortID = ? WHERE TourID = ?";
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setDouble(2, price);
            stmt.setDate(3, Date.valueOf(startDate));
            stmt.setDate(4, Date.valueOf(endDate));
            stmt.setInt(5, resortId);
            stmt.setInt(6, tourId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating tour: " + e.getMessage(), e);
        }
    }

    @Override
    public void deleteTour(int tourId) {
        String sql = "DELETE FROM Tours WHERE TourID = ?";
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, tourId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting tour: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Tour> searchTours(String keyword) {
        String sql = "SELECT * FROM Tours WHERE Name LIKE ?";
        List<Tour> tours = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, "%" + keyword + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                tours.add(new Tour(
                        rs.getInt("TourID"),
                        rs.getString("Name"),
                        rs.getDouble("Price"),
                        rs.getString("StartDate"),
                        rs.getString("EndDate"),
                        rs.getInt("ResortID")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error searching tours: " + e.getMessage(), e);
        }
        return tours;
    }


    @Override
    public List<Tour> displayAllTours() {
        String sql = "SELECT * FROM Tours";
        List<Tour> tours = new ArrayList<>();
        try (Connection connection = getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                tours.add(new Tour(
                        rs.getInt("TourID"),           // id
                        rs.getString("Name"),          // name
                        rs.getDouble("Price"),         // price
                        rs.getString("StartDate"),     // startDate
                        rs.getString("EndDate"),       // endDate
                        rs.getInt("ResortID")          // resortId
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all tours: " + e.getMessage(), e);
        }
        return tours;
    }


    // ===== Bookings =====
    @Override
    public void addBooking(String touristName, String contactInfo, int tourId, String status) {
        String sql = "INSERT INTO Bookings (TouristName, ContactInfo, TourID, Status) VALUES (?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, touristName);
            stmt.setString(2, contactInfo);
            stmt.setInt(3, tourId);
            stmt.setString(4, status);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error adding booking: " + e.getMessage(), e);
        }
    }

    @Override
    public void updateBooking(int bookingId, String touristName, String contactInfo, int tourId, String status) {
        String sql = "UPDATE Bookings SET TouristName = ?, ContactInfo = ?, TourID = ?, Status = ? WHERE BookingID = ?";
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, touristName);
            stmt.setString(2, contactInfo);
            stmt.setInt(3, tourId);
            stmt.setString(4, status);
            stmt.setInt(5, bookingId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating booking: " + e.getMessage(), e);
        }
    }

    @Override
    public void deleteBooking(int bookingId) {
        String sql = "DELETE FROM Bookings WHERE BookingID = ?";
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, bookingId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting booking: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Booking> searchBookings(String keyword) {
        String sql = "SELECT * FROM Bookings WHERE TouristName LIKE ?";
        List<Booking> bookings = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, "%" + keyword + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                bookings.add(new Booking(
                        rs.getInt("BookingID"),
                        rs.getString("TouristName"),
                        rs.getString("ContactInfo"),
                        rs.getInt("TourID"),
                        rs.getString("Status")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error searching bookings: " + e.getMessage(), e);
        }
        return bookings;
    }

    @Override
    public List<Booking> displayAllBookings() {
        String sql = "SELECT * FROM Bookings";
        List<Booking> bookings = new ArrayList<>();
        try (Connection connection = getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                bookings.add(new Booking(
                        rs.getInt("BookingID"),         // id
                        rs.getString("TouristName"),    // touristName
                        rs.getString("ContactInfo"),    // contactInfo
                        rs.getInt("TourID"),            // tourId
                        rs.getString("Status")          // status
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all bookings: " + e.getMessage(), e);
        }
        return bookings;
    }

}