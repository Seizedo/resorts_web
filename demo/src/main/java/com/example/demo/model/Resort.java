package com.example.demo.model;

public class Resort {
    private int id;
    private String name;
    private String location;
    private String type;
    private double rating;

    public Resort(int id, String name, String location, String type, double rating) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.type = type;
        this.rating = rating;
    }

    // Геттери та сеттери
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}