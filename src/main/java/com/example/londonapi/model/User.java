package com.example.londonapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The User Model for the API. This will ignore any new properties added to the external API
 * @implNote  If new properties added to the external API, add them w/ Getters & Setters.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private String ip_address;
    private double latitude;
    private double longitude;

    public User(int id, String first_name, String last_name, String email, String ip_address, double latitude, double longitude) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.ip_address = ip_address;
        this.latitude = latitude;
        this.longitude = longitude;
    }
//This empty constructor is needed for Jackson to map.
    public User() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getIp_address() {
        return ip_address;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
