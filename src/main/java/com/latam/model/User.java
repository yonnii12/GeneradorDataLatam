package com.latam.model;

public abstract class User {

    protected String name;
    protected String city;
    protected String country;

    public User(String name, String city, String country) {
        this.name = name;
        this.city = city;
        this.country = country;
    }

    public abstract String generateDocument();
    public abstract String getLanguage();

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
}
