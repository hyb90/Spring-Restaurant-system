package com.humam.restaurants.extras;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.humam.restaurants.models.Category;
import com.humam.restaurants.models.Image;

import java.io.IOException;

public class ImageSerializer extends JsonSerializer<Image> {
    public ImageSerializer() {
    }

    public void serialize(Image value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        if (value == null) {
            gen.writeNull();
        } else {
            gen.writeStartObject();
            gen.writeNumberField("id", value.getId());
            gen.writeStringField("title", value.getTitle());
            gen.writeStringField("path", value.getImagePath());
            gen.writeEndObject();
        }
    }
}
