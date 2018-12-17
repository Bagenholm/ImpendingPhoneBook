package fileio;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import data.Contact;
import data.ContactBook;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class LocalDateSerializerTest {


    @Test
    void serializeDateGiveExpectedOutputFormatEvenIfMonthEnteredAsEnum() {


      Contact contact = new Contact("", "", "", LocalDate.of(1989, Month.OCTOBER, 15), "", "");

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            assertEquals("{\"number\":\"\",\"name\":\"\",\"email\":\"\",\"note\":\"\",\"address\":\"\",\"image\":\"\",\"birthDate\":\"1989-10-15\"}", objectMapper.writeValueAsString(contact));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }
}