package com.example.demo.model;

public class Service {

    private int id;
    private String name;
    private String description;
    private int resortId;

    // Конструктор без параметрів
    public Service() {
    }

    // Конструктор з параметрами
    public Service(int id, String name, String description, int resortId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.resortId = resortId;
    }

    // Гетери та сетери

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getResortId() {
        return resortId;
    }

    public void setResortId(int resortId) {
        this.resortId = resortId;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", resortId=" + resortId +
                '}';
    }
}

