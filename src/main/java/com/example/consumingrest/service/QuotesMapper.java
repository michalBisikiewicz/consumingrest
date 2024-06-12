package com.example.consumingrest.service;

import com.example.consumingrest.proxy.Value;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class QuotesMapper {

    private final ObjectMapper objectMapper;

    public QuotesMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    Value mapJsonValueResponse(String json) {
        try {
            return objectMapper.readValue(json, Value.class);
        } catch (JsonProcessingException e) {
            log.error("QuotesMapper could not map json");
            return new Value(0L, "error");
        }
    }
}
