package com.inditex.manuelMartin.utils;

import com.inditex.manuelMartin.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Component
public class DateUtils {

    @Autowired
    private Environment env;

    public LocalDateTime getLocalDateTime(String date) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(env.getProperty("date.pattern"));
            LocalDateTime localDateTime = LocalDateTime.parse(date, formatter);
            return localDateTime;
        } catch(DateTimeParseException e) {
            throw new ApiRequestException(env.getProperty("date.format.error"));
        }
    }
}
