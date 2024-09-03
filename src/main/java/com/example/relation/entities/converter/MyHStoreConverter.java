package com.example.relation.entities.converter;


import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.postgresql.util.HStoreConverter;

import java.util.Map;

@Converter
public class MyHStoreConverter implements AttributeConverter<Map<String, String>, String> {
    @Override
    public String convertToDatabaseColumn(Map<String, String> attribute) {
        return HStoreConverter.toString(attribute);
    }

    @Override
    public Map<String, String> convertToEntityAttribute(String dbData) {
        return HStoreConverter.fromString(dbData);
    }
}