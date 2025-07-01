package com.springjpa.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class UtilService {
    public static LocalDateTime toDateTimeWithCurrentTime(LocalDate date) {
        LocalTime heureActuelle = LocalTime.now();
        return date.atTime(heureActuelle);
    }
}
