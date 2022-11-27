package fr.mat.citizen.utils;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class DateUtils {

    public LocalDate dateToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public int getAge(Date birthDate) {
        Period diff = Period.between(dateToLocalDate(birthDate), dateToLocalDate(new Date()));

        return diff.getYears();
    }

    public boolean isValidDate(Date date) {
        return getAge(date) >= 0;
    }

    public String dateFormat(Date date) {
        DateFormat dateFormat = DateFormat.getDateInstance();
        return dateFormat.format(date);
    }

    public final String invalidDateErrorMessage = "Error: invalid date.";

}
