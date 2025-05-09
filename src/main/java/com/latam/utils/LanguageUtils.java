package com.latam.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LanguageUtils {
    private static final List<String> LANGUAGES = Arrays.asList(
            "Inglés", "Francés", "Alemán", "Italiano", "Portugués", "Árabe", "Japonés", "Ruso", "Coreano", "Mandarin", "Checo", "Indonesio");

    public static String getRandomLanguage() {
        return LANGUAGES.get(new Random().nextInt(LANGUAGES.size()));
    }
}
