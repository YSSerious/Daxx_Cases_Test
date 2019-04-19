package com.paazl.cases.test4.csv;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateHelper {

    private static final String datePatter = "dd/MM/yyyy";

    public static Date parseStringToDate(String date) {
        SimpleDateFormat formatter1 = new SimpleDateFormat(datePatter);
        try {
            return formatter1.parse(date);
        } catch (ParseException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public static String parseDateToString(Date date) {
        return new SimpleDateFormat(datePatter).format(date);
    }

    public static Date incrementDate(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        return c.getTime();
    }
}
