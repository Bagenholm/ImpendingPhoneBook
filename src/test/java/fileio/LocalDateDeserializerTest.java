package fileio;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.Contact;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class LocalDateDeserializerTest {


    @Test
    void deserializeBackCorrectlyToLocalDateObject() {

        Contact contact = new Contact("", "", "", LocalDate.of(1989, Month.OCTOBER, 15), "", "");

        ObjectMapper objectMapper = new ObjectMapper();

        String jsonString = null;

        try {
        jsonString = objectMapper.writeValueAsString(contact);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        Contact importedContact = null;

        try {
          importedContact = objectMapper.readValue(jsonString, Contact.class);
        } catch (IOException e) {
            e.printStackTrace();

        }

        LocalDate localDate = LocalDate.of(1989,10,15);
        assertEquals(LocalDate.class, importedContact.getBirthDate().getClass());
        assertTrue(localDate.equals(importedContact.getBirthDate()));


    }
}