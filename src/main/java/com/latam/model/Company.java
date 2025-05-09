package com.latam.model;

import com.latam.utils.LanguageUtils;

import java.util.Random;

public class Company extends User {
    private int age;

    public Company(String name, String city, String country) {
        super(name, city, country);
        this.age = new Random().nextInt(69) + 11; // Edad entre 11 y 79
    }

    @Override
    public String generateDocument() {
        return "9" + (int)(10000000 + Math.random() * 89999999);
    }

    @Override
    public String getLanguage() {
        return country.equalsIgnoreCase("colombia") ? "Español" : LanguageUtils.getRandomLanguage();
    }

    public int getAge() {
        return age;
    }
}
