package com.example.mcfinder.models;

public class Store {

    private String StoreName;
    private String Street;
    private String City;
    private String Postcode;
    private String Telephone;
    private double Latitude;
    private double Longitude;

    public Store(String storeName, String street, String city, String postcode, String telephone, double latitude, double longitude) {
        StoreName = storeName;
        Street = street;
        City = city;
        Postcode = postcode;
        Telephone = telephone;
        Latitude = latitude;
        Longitude = longitude;
    }


    public String getStoreName() {
        return StoreName;
    }

    public void setStoreName(String storeName) {
        StoreName = storeName;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getPostcode() {
        return Postcode;
    }

    public void setPostcode(String postcode) {
        Postcode = postcode;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String telephone) {
        Telephone = telephone;
    }

    public double getLatitude() {
        return Latitude;
    }

    public void setLatitude(double latitude) {
        Latitude = latitude;
    }

    public double getLongitude() {
        return Longitude;
    }

    public void setLongitude(double longitude) {
        Longitude = longitude;
    }

}
