package com.example.demo.model;

public class Booking {

    private int id;
    private String touristName;
    private String contactInfo;
    private int tourId;
    private String status;

    // Конструктор без параметрів
    public Booking() {
    }

    // Конструктор з параметрами
    public Booking(int id, String touristName, String contactInfo, int tourId, String status) {
        this.id = id;
        this.touristName = touristName;
        this.contactInfo = contactInfo;
        this.tourId = tourId;
        this.status = status;
    }

    // Гетери та сетери

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTouristName() {
        return touristName;
    }

    public void setTouristName(String touristName) {
        this.touristName = touristName;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public int getTourId() {
        return tourId;
    }

    public void setTourId(int tourId) {
        this.tourId = tourId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", touristName='" + touristName + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ", tourId=" + tourId +
                ", status='" + status + '\'' +
                '}';
    }
}
