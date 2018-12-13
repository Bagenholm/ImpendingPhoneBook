package fileio;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * This is a supporting class for Jackson to be able to serialize LocalDates in our contact file
 */

public class LocalDateSerializer extends StdSerializer<LocalDate> {



    public LocalDateSerializer() {
        super(LocalDate.class);
    }

    @Override
    public void serialize(LocalDate value, JsonGenerator generator, SerializerProvider provider) throws IOException {
        try {
            generator.writeString(value.format(DateTimeFormatter.ISO_LOCAL_DATE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
