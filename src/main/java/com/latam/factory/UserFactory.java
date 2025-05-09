package com.latam.factory;

import com.github.javafaker.Faker;
import com.latam.model.Company;
import com.latam.model.Person;
import com.latam.model.User;

import java.util.Locale;
import java.util.Random;

public class UserFactory {

    private static final Faker faker = new Faker(new Locale("es", "CO"));
    private static final Random random = new Random();

    public static User createUser(String type) {
        String city = faker.address().city();
        String country = faker.address().country();

        if ("person".equalsIgnoreCase(type)) {
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            int age = random.nextInt(69) + 11; // Entre 11 y 79

            return new Person(firstName, lastName, age, city, country);
        } else if ("company".equalsIgnoreCase(type)) {
            String companyName = faker.company().name();
            return new Company(companyName, city, country);
        } else {
            throw new IllegalArgumentException("Tipo de usuario no válido: " + type);
        }
    }
}
