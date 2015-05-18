package com.example.fing.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;


public class DateUtil {

    private static Date date = null;

    public static void setDateForTest(Date dateForTest) {
        date = dateForTest;
    }

    private static Date getNewDate() {
        if (date != null) {
            return date;
        } else {
            return new Date();
        }
    }

    /**
     * Convert a date string in format yyyy-MM-dd HH:mm:ss to a date
     *
     * @param date in format yyyy-MM-dd HH:mm:ss
     * @return the date
     * @throws ParseException
     */
    public static Date getDateTime(String date) throws ParseException {
        SimpleDateFormat inputFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        inputFormatter.setTimeZone(TimeZone.getTimeZone("GMT"));
        return inputFormatter.parse(date);
    }

    /**
     * Get formatted date x days from today. To get past dates use negative numbers.
     * Ex: Yesterday: daysFromNow = -1
     **/
    public static Date getDateDaysFromToday(int daysFromNow) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, daysFromNow);
        cal.set(Calendar.HOUR, 8);
        cal.set(Calendar.MINUTE, 0);
        return cal.getTime();
    }

    public static Date getTodayAtHour(int hour) {
        Date now = getNewDate();
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(now);
        calendar.set(Calendar.HOUR, hour);
        return calendar.getTime();
    }

    public static boolean isBeforeAfternoon() {
        Date now = getNewDate();
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(now);
        return (calendar.get(Calendar.HOUR_OF_DAY) <= 13);
    }

    public static boolean isBeforeEvening() {
        Date now = getNewDate();
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(now);
        return (calendar.get(Calendar.HOUR_OF_DAY) <= 18);
    }

    /**
     * Get date x hours from today. To get past dates use negative numbers.
     * Ex: Yesterday: hoursFromNow = -1
     **/
    public static Date getDateHoursFromNow(int hoursFromNow) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR, hoursFromNow);
        return cal.getTime();
    }

    /**
     * Get date x hours from today. To get past dates use negative numbers.
     * Ex: Yesterday: hoursFromNow = -1
     **/
    public static Date getDateMinutesFromNow(int minutesFromNow) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, minutesFromNow);
        return cal.getTime();
    }
}
