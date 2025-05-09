package com.latam;

import com.latam.db.DatabaseManager;
import com.latam.factory.UserFactory;
import com.latam.model.Company;
import com.latam.model.Person;
import com.latam.model.User;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

public class App {
    public static void main(String[] args) {
        int total = args.length > 0 ? Integer.parseInt(args[0]) : 100;

        Set<String> uniqueNames = new HashSet<>();
        Set<String> uniqueDocs = new HashSet<>();

        DatabaseManager db = DatabaseManager.getInstance();

        try (PrintWriter writer = new PrintWriter(new FileWriter("users.csv"))) {
            writer.println("Name,LastName,Age,Document,City,Country,Language");

            while (total > 0) {
                String type = Math.random() < 0.5 ? "person" : "company";
                User user = UserFactory.createUser(type);

                String name = user.getName();
                String lastName = "";
                String age = "";

                if (user instanceof Person) {
                    lastName = ((Person) user).getLastName();
                    age = String.valueOf(((Person) user).getAge());
                } else if (user instanceof Company) {
                    age = String.valueOf(((Company) user).getAge());
                }

                String document = user.generateDocument();

                // Validaciones de unicidad
                if (!uniqueNames.add(name + lastName) || !uniqueDocs.add(document)) {
                    continue; // Si se repite, lo ignoramos
                }

                String[] userData = {
                        name != null ? name : "",
                        lastName != null ? lastName : "",
                        age != null ? age : "",
                        document,
                        user.getCity(),
                        user.getCountry(),
                        user.getLanguage()
                };

                db.saveUser(userData);
                writer.println(String.join(",", userData));
                total--;
            }

            System.out.println("🎉 Usuarios generados exitosamente y guardados en users.csv y base de datos.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}