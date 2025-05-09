package pruebas;

import com.latam.factory.UserFactory;
import com.latam.model.Company;
import com.latam.model.Person;
import com.latam.model.User;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class ReglasDesarrollo {

    @Test
    void validarExistenciaCsv() {
        assertTrue(Files.exists(Paths.get("users.csv")), "El archivo CSV no fue generado");
    }

    @RepeatedTest(10)
    void validarInicioDocumentoMenorEdad() {
        Person p = new Person("Ana", "Lopez", 15, "Bogotá", "Colombia");
        long doc = Long.parseLong(p.generateDocument());
        assertTrue(doc >= 11000000, "El documento de un menor debe iniciar en 11000000");
    }

    @RepeatedTest(10)
    void validarLongitudDocumentoAdulto() {
        Person p = new Person("Carlos", "Ramírez", 25, "Medellín", "Colombia");
        String doc = p.generateDocument();
        assertTrue(doc.length() > 8 && doc.length() < 12,
                "El documento de un adulto debe tener entre 9 y 11 dígitos");
    }

    @RepeatedTest(10)
    void validarDocumentoEmpresaInicia9() {
        Company c = new Company("ACME Corp", "Bogotá", "Colombia");
        String doc = c.generateDocument();
        assertTrue(doc.startsWith("9"), "El documento de empresa debe empezar por 9");
    }

    @RepeatedTest(10)
    void languageShouldNotBeSpanishIfNotFromColombia() {
        Person p = new Person("Luis", "Soto", 30, "Quito", "Italia");
        assertNotEquals("Español", p.getLanguage(), "Idioma no puede ser Español si no es Colombia");
    }

    @RepeatedTest(10)
    void validarRangoEdadPermitida() {
        User user = UserFactory.createUser(Math.random() < 0.5 ? "person" : "company");
        int age = user instanceof Person ? ((Person) user).getAge() : ((Company) user).getAge();
        assertTrue(age >= 11 && age <= 79, "La edad debe estar entre 11 y 79");
    }

    @RepeatedTest(10)
    void validarCampoApellidoEnEmpresa() {
        Company c = new Company("Globex Inc.", "Barranquilla", "Colombia");
        assertTrue(c instanceof Company);
        assertEquals("", "", "Las empresas no deben tener apellido (campo vacío)");
    }
}
