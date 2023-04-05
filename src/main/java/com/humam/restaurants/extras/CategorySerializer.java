package com.humam.restaurants.extras;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.humam.restaurants.models.Category;

import javax.persistence.Entity;
import java.io.IOException;

public class CategorySerializer extends JsonSerializer<Category> {
    public CategorySerializer() {
    }

    public void serialize(Category value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        if (value == null) {
            gen.writeNull();
        } else {
            gen.writeStartObject();
            gen.writeNumberField("id", value.getId());
            gen.writeStringField("name", value.getName());
            gen.writeEndObject();
        }
    }
}
