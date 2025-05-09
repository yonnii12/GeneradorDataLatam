package com.latam.model;

import com.latam.utils.LanguageUtils;

public class Person extends User {
    private String lastName;
    private int age;

    public Person(String name, String lastName, int age, String city, String country) {
        super(name, city, country);
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String generateDocument() {
        if (age < 18) {
            return String.valueOf((int) (11000000 + Math.random() * 899999));
        } else {
            return String.valueOf((long) (100000000L + Math.random() * 899999999L));
        }
    }

    @Override
    public String getLanguage() {
        return country.equalsIgnoreCase("colombia") ? "Español" : LanguageUtils.getRandomLanguage();
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }
}
