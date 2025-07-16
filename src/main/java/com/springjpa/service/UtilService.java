package com.springjpa.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class UtilService {
    public static LocalDateTime toDateTimeWithCurrentTime(LocalDate date) {
        LocalTime heureActuelle = LocalTime.now();
        return date.atTime(heureActuelle);
    }

    public static boolean periodesSeChevauchent(LocalDateTime debut1, LocalDateTime fin1,
                                                LocalDateTime debut2, LocalDateTime fin2) {
        return !debut1.isAfter(fin2) && !debut2.isAfter(fin1);
    }

    public static LocalDateTime ajouterJours(LocalDateTime date, int nbJours) {
        return date.plusDays(nbJours);
    }

    public static boolean estLeMemeJour(LocalDateTime dateTime, LocalDate date) {
        if (dateTime.toLocalDate().equals(date)) {
            return true;
        }
        return false;
    }
}
