package com.z5.zcms.util;

import com.ibm.icu.util.Calendar;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


public final class DateUtil {

    /**
     * Don't let anyone instantiate this class
     */
    private DateUtil() {
    }

    /**
     * check date string validation with the default format "yyyyMMdd".
     *
     * @param s date string you want to check with default format "yyyyMMdd".
     * @return date java.util.Date
     */
    public static Date getDate(String s) throws java.text.ParseException {
        return getDate(s, "yyyyMMdd");
    }

    /**
     * check date string validation with an user defined format.
     *
     * @param s      date string you want to check.
     * @param format string representation of the date format. For example, "yyyy-MM-dd".
     * @return date java.util.Date
     */
    public static Date getDate(String s, String format) throws java.text.ParseException {
        if (s == null)
            throw new java.text.ParseException("date string to check is null", 0);
        if (format == null)
            throw new java.text.ParseException("format string to check date is null", 0);

        SimpleDateFormat formatter = new SimpleDateFormat(format, java.util.Locale.KOREA);
        Date             date      = null;
        try {
            date = formatter.parse(s);
        } catch (java.text.ParseException e) {
            /*
            throw new java.text.ParseException( e.getMessage() + " with format \"" + format + "\"", e.getErrorOffset());
            */
            throw new java.text.ParseException(" wrong date:\"" + s + "\" with format \"" + format + "\"", 0);
        }

        if (!formatter.format(date).equals(s))
            throw new java.text.ParseException("Out of bound date:\"" + s + "\" with format \"" + format + "\"", 0);
        return date;
    }

    /**
     * check date string validation with the default format "yyyyMMdd".
     *
     * @param s date string you want to check with default format "yyyyMMdd"
     * @return boolean true 날짜 형식이 맞고, 존재하는 날짜일 때
     * false 날짜 형식이 맞지 않거나, 존재하지 않는 날짜일 때
     */
    public static boolean isValid(String s) throws Exception {
        return DateUtil.isValid(s, "yyyyMMdd");
    }

    /**
     * check date string validation with an user defined format.
     *
     * @param s      date string you want to check.
     * @param format string representation of the date format. For example, "yyyy-MM-dd".
     * @return boolean true 날짜 형식이 맞고, 존재하는 날짜일 때
     * false 날짜 형식이 맞지 않거나, 존재하지 않는 날짜일 때
     */
    public static boolean isValid(String s, String format) {

        SimpleDateFormat formatter =
                new SimpleDateFormat(format, java.util.Locale.KOREA);
        Date date = null;
        try {
            date = formatter.parse(s);
        } catch (java.text.ParseException e) {
            return false;
        }

        return formatter.format(date).equals(s);
    }

    /**
     * @return formatted string representation of current day with  "yyyy-MM-dd".
     */
    public static String getDateString() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", java.util.Locale.KOREA);
        return formatter.format(new Date());
    }

    public static int getHour() {
        return getNumberByPattern("hh");
    }

    /**
     * For example, String time = DateUtil.getFormatString("yyyy-MM-dd HH:mm:ss");
     *
     * @param java.lang.String pattern  "yyyy, MM, dd, HH, mm, ss and more"
     * @return formatted string representation of current day and time with  your pattern.
     */
    public static int getDay() {
        return getNumberByPattern("dd");
    }

    /**
     * For example, String time = DateUtil.getFormatString("yyyy-MM-dd HH:mm:ss");
     *
     * @param java.lang.String pattern  "yyyy, MM, dd, HH, mm, ss and more"
     * @return formatted string representation of current day and time with  your pattern.
     */
    public static int getYear() {
        return getNumberByPattern("yyyy");
    }

    public static String getYearString() {
        return Integer.toString(getNumberByPattern("yyyy"));
    }

    /**
     * For example, String time = DateUtil.getFormatString("yyyy-MM-dd HH:mm:ss");
     *
     * @param java.lang.String pattern  "yyyy, MM, dd, HH, mm, ss and more"
     * @return formatted string representation of current day and time with  your pattern.
     */
    public static int getMonth() {
        return getNumberByPattern("MM");
    }

    /**
     * For example, String time = DateUtil.getFormatString("yyyy-MM-dd HH:mm:ss");
     *
     * @param java.lang.String pattern  "yyyy, MM, dd, HH, mm, ss and more"
     * @return formatted string representation of current day and time with  your pattern.
     */
    public static int getNumberByPattern(String pattern) {
        SimpleDateFormat formatter  = new SimpleDateFormat(pattern, java.util.Locale.KOREA);
        String           dateString = formatter.format(new Date());
        return Integer.parseInt(dateString);
    }

    /**
     * For example, String time = DateUtil.getFormatString("yyyy-MM-dd HH:mm:ss");
     *
     * @param java.lang.String pattern  "yyyy, MM, dd, HH, mm, ss and more"
     * @return formatted string representation of current day and time with  your pattern.
     */
    public static String getFormatString(String pattern) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern, java.util.Locale.KOREA);
        return formatter.format(new Date());
    }

    /**
     * @return formatted string representation of current day with  "yyyyMMdd".
     */
    public static String getShortDateString() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd", java.util.Locale.KOREA);
        return formatter.format(new Date());
    }

    /**
     * @return formatted string representation of current time with  "HHmmss".
     */
    public static String getShortTimeString() {
        SimpleDateFormat formatter =
                new SimpleDateFormat("HHmmss", java.util.Locale.KOREA);
        return formatter.format(new Date());
    }

    /**
     * @return formatted string representation of current time with  "yyyy-MM-dd-HH:mm:ss".
     */
    public static String getTimeStampString() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss:SSS", java.util.Locale.KOREA);
        return formatter.format(new Date());
    }

    public static String getTimeStampString(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss:SSS", java.util.Locale.KOREA);
        return formatter.format(date);
    }

    public static String getTimeStampString(String pattern) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern, java.util.Locale.KOREA);
        return formatter.format(new Date());
    }

    /**
     * @return formatted string representation of current time with  "HH:mm:ss".
     */
    public static String getTimeString() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss", java.util.Locale.KOREA);
        return formatter.format(new Date());
    }


    /**
     * return days between two date strings with default defined format.(yyyyMMdd)
     *
     * @param s date string you want to check.
     * @return int 날짜 형식이 맞고, 존재하는 날짜일 때 요일을 리턴
     * 형식이 잘못 되었거나 존재하지 않는 날짜: java.text.ParseException 발생
     * 0: 일요일 (java.util.Calendar.SUNDAY 와 비교)
     * 1: 월요일 (java.util.Calendar.MONDAY 와 비교)
     * 2: 화요일 (java.util.Calendar.TUESDAY 와 비교)
     * 3: 수요일 (java.util.Calendar.WENDESDAY 와 비교)
     * 4: 목요일 (java.util.Calendar.THURSDAY 와 비교)
     * 5: 금요일 (java.util.Calendar.FRIDAY 와 비교)
     * 6: 토요일 (java.util.Calendar.SATURDAY 와 비교)
     * 예) String s = "20000529";
     * int dayOfWeek = whichDay(s, format);
     * if (dayOfWeek == java.util.Calendar.MONDAY)
     * System.out.println(" 월요일: " + dayOfWeek);
     * if (dayOfWeek == java.util.Calendar.TUESDAY)
     * System.out.println(" 화요일: " + dayOfWeek);
     */
    public static int whichDay(String s) throws java.text.ParseException {
        return whichDay(s, "yyyyMMdd");
    }

    /**
     * return days between two date strings with user defined format.
     *
     * @param s      date string you want to check.
     * @param format string representation of the date format. For example, "yyyy-MM-dd".
     * @return int 날짜 형식이 맞고, 존재하는 날짜일 때 요일을 리턴
     * 형식이 잘못 되었거나 존재하지 않는 날짜: java.text.ParseException 발생
     * 0: 일요일 (java.util.Calendar.SUNDAY 와 비교)
     * 1: 월요일 (java.util.Calendar.MONDAY 와 비교)
     * 2: 화요일 (java.util.Calendar.TUESDAY 와 비교)
     * 3: 수요일 (java.util.Calendar.WENDESDAY 와 비교)
     * 4: 목요일 (java.util.Calendar.THURSDAY 와 비교)
     * 5: 금요일 (java.util.Calendar.FRIDAY 와 비교)
     * 6: 토요일 (java.util.Calendar.SATURDAY 와 비교)
     * 예) String s = "2000-05-29";
     * int dayOfWeek = whichDay(s, "yyyy-MM-dd");
     * if (dayOfWeek == java.util.Calendar.MONDAY)
     * System.out.println(" 월요일: " + dayOfWeek);
     * if (dayOfWeek == java.util.Calendar.TUESDAY)
     * System.out.println(" 화요일: " + dayOfWeek);
     */

    public static int whichDay(String s, String format) throws java.text.ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(format, java.util.Locale.KOREA);
        Date date = getDate(s, format);

        java.util.Calendar calendar = formatter.getCalendar();
        calendar.setTime(date);
        return calendar.get(java.util.Calendar.DAY_OF_WEEK);
    }

    /**
     * return days between two date strings with default defined format.("yyyyMMdd")
     *
     * @param String from date string
     * @param String to date string
     * @return int 날짜 형식이 맞고, 존재하는 날짜일 때 2개 일자 사이의 나이 리턴
     * 형식이 잘못 되었거나 존재하지 않는 날짜: java.text.ParseException 발생
     */
    public static int daysBetween(String from, String to) throws java.text.ParseException {
        return daysBetween(from, to, "yyyyMMdd");
    }

    /**
     * return days between two date strings with user defined format.
     *
     * @param String from date string
     * @param String to date string
     * @return int 날짜 형식이 맞고, 존재하는 날짜일 때 2개 일자 사이의 일자 리턴
     * 형식이 잘못 되었거나 존재하지 않는 날짜: java.text.ParseException 발생
     */
    public static int daysBetween(String from, String to, String format) throws java.text.ParseException {
        Date d1 = getDate(from, format);
        Date d2 = getDate(to, format);

        long duration = d2.getTime() - d1.getTime();

        return (int) (duration / (1000 * 60 * 60 * 24));
        // seconds in 1 day
    }

    /**
     * return age between two date strings with default defined format.("yyyyMMdd")
     *
     * @param String from date string
     * @param String to date string
     * @return int 날짜 형식이 맞고, 존재하는 날짜일 때 2개 일자 사이의 나이 리턴
     * 형식이 잘못 되었거나 존재하지 않는 날짜: java.text.ParseException 발생
     */
    public static int ageBetween(String from, String to) throws java.text.ParseException {
        return ageBetween(from, to, "yyyyMMdd");
    }

    /**
     * return age between two date strings with user defined format.
     *
     * @param String from date string
     * @param String to date string
     * @param format string representation of the date format. For example, "yyyy-MM-dd".
     * @return int 날짜 형식이 맞고, 존재하는 날짜일 때 2개 일자 사이의 나이 리턴
     * 형식이 잘못 되었거나 존재하지 않는 날짜: java.text.ParseException 발생
     */
    public static int ageBetween(String from, String to, String format) throws java.text.ParseException {
        return daysBetween(from, to, format) / 365;
    }

    /**
     * return add day to date strings
     *
     * @param String date string
     * @param int    더할 일수
     * @return int 날짜 형식이 맞고, 존재하는 날짜일 때 일수 더하기
     * 형식이 잘못 되었거나 존재하지 않는 날짜: java.text.ParseException 발생
     */
    public static String addDays(String s, int day) throws java.text.ParseException {
        return addDays(s, day, "yyyyMMdd");
    }

    /**
     * return add day to date strings with user defined format.
     *
     * @param String date string
     * @param int    더할 일수
     * @param format string representation of the date format. For example, "yyyy-MM-dd".
     * @return int 날짜 형식이 맞고, 존재하는 날짜일 때 일수 더하기
     * 형식이 잘못 되었거나 존재하지 않는 날짜: java.text.ParseException 발생
     */
    public static String addDays(String s, int day, String format) throws java.text.ParseException {
        SimpleDateFormat formatter =
                new SimpleDateFormat(format, java.util.Locale.KOREA);
        Date date = getDate(s, format);

        date.setTime(date.getTime() + ((long) day * 1000 * 60 * 60 * 24));
        return formatter.format(date);
    }

    /**
     * return add month to date strings
     *
     * @param String date string
     * @param int    더할 월수
     * @return int 날짜 형식이 맞고, 존재하는 날짜일 때 월수 더하기
     * 형식이 잘못 되었거나 존재하지 않는 날짜: java.text.ParseException 발생
     */
    public static String addMonths(String s, int month) throws Exception {
        return addMonths(s, month, "yyyyMMdd");
    }

    /**
     * return add month to date strings with user defined format.
     *
     * @param String date string
     * @param int    더할 월수
     * @param format string representation of the date format. For example, "yyyy-MM-dd".
     * @return int 날짜 형식이 맞고, 존재하는 날짜일 때 월수 더하기
     * 형식이 잘못 되었거나 존재하지 않는 날짜: java.text.ParseException 발생
     */
    public static String addMonths(String s, int addMonth, String format) throws Exception {
        SimpleDateFormat formatter =
                new SimpleDateFormat(format, java.util.Locale.KOREA);
        Date date = getDate(s, format);

        SimpleDateFormat yearFormat =
                new SimpleDateFormat("yyyy", java.util.Locale.KOREA);
        SimpleDateFormat monthFormat =
                new SimpleDateFormat("MM", java.util.Locale.KOREA);
        SimpleDateFormat dayFormat =
                new SimpleDateFormat("dd", java.util.Locale.KOREA);
        int year  = Integer.parseInt(yearFormat.format(date));
        int month = Integer.parseInt(monthFormat.format(date));
        int day   = Integer.parseInt(dayFormat.format(date));

        month += addMonth;
        if (addMonth > 0) {
            while (month > 12) {
                month -= 12;
                year += 1;
            }
        } else {
            while (month <= 0) {
                month += 12;
                year -= 1;
            }
        }
        DecimalFormat fourDf = new DecimalFormat("0000");
        DecimalFormat twoDf  = new DecimalFormat("00");
        String tempDate = fourDf.format(year)
                + twoDf.format(month)
                + twoDf.format(day);
        Date targetDate = null;

        try {
            targetDate = getDate(tempDate, "yyyyMMdd");
        } catch (java.text.ParseException pe) {
            day = lastDay(year, month);
            tempDate = fourDf.format(year)
                    + twoDf.format(month)
                    + twoDf.format(day);
            targetDate = getDate(tempDate, "yyyyMMdd");
        }

        return formatter.format(targetDate);
    }

    public static String addYears(String s, int year) throws java.text.ParseException {
        return addYears(s, year, "yyyyMMdd");
    }

    public static String addYears(String s, int year, String format) throws java.text.ParseException {
        SimpleDateFormat formatter =
                new SimpleDateFormat(format, java.util.Locale.KOREA);
        Date date = getDate(s, format);
        date.setTime(date.getTime() + ((long) year * 1000 * 60 * 60 * 24 * (365 + 1)));
        return formatter.format(date);
    }

    public static int monthsBetween(String from, String to) throws java.text.ParseException {
        return monthsBetween(from, to, "yyyyMMdd");
    }

    public static int monthsBetween(String from, String to, String format) throws java.text.ParseException {
        Date fromDate = getDate(from, format);
        Date toDate   = getDate(to, format);

        // if two date are same, return 0.
        if (fromDate.compareTo(toDate) == 0) return 0;

        SimpleDateFormat yearFormat =
                new SimpleDateFormat("yyyy", java.util.Locale.KOREA);
        SimpleDateFormat monthFormat =
                new SimpleDateFormat("MM", java.util.Locale.KOREA);
        SimpleDateFormat dayFormat =
                new SimpleDateFormat("dd", java.util.Locale.KOREA);

        int fromYear  = Integer.parseInt(yearFormat.format(fromDate));
        int toYear    = Integer.parseInt(yearFormat.format(toDate));
        int fromMonth = Integer.parseInt(monthFormat.format(fromDate));
        int toMonth   = Integer.parseInt(monthFormat.format(toDate));
        int fromDay   = Integer.parseInt(dayFormat.format(fromDate));
        int toDay     = Integer.parseInt(dayFormat.format(toDate));

        int result = 0;
        result += ((toYear - fromYear) * 12);
        result += (toMonth - fromMonth);

//        if (((toDay - fromDay) < 0) ) result += fromDate.compareTo(toDate);
        // ceil과 floor의 효과
        if (((toDay - fromDay) > 0)) result += toDate.compareTo(fromDate);

        return result;
    }

    public static String lastDayOfMonth(String src) throws java.text.ParseException {
        return lastDayOfMonth(src, "yyyyMMdd");
    }

    public static String lastDayOfMonth(String src, String format) throws java.text.ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(format, java.util.Locale.KOREA);
        Date             date      = getDate(src, format);

        SimpleDateFormat yearFormat  = new SimpleDateFormat("yyyy", java.util.Locale.KOREA);
        SimpleDateFormat monthFormat = new SimpleDateFormat("MM", java.util.Locale.KOREA);

        int year  = Integer.parseInt(yearFormat.format(date));
        int month = Integer.parseInt(monthFormat.format(date));
        int day   = lastDay(year, month);

        DecimalFormat fourDf   = new DecimalFormat("0000");
        DecimalFormat twoDf    = new DecimalFormat("00");
        String        tempDate = fourDf.format(year) + twoDf.format(month) + twoDf.format(day);
        date = getDate(tempDate, format);
        return formatter.format(date);
    }

    private static int lastDay(int year, int month) throws java.text.ParseException {
        int day = 0;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                day = 31;
                break;
            case 2:
                if ((year % 4) == 0) {
                    if ((year % 100) == 0 && (year % 400) != 0) {
                        day = 28;
                    } else {
                        day = 29;
                    }
                } else {
                    day = 28;
                }
                break;
            default:
                day = 30;
        }
        return day;
    }

    public static boolean isNew(String date, int hour) throws java.text.ParseException {
        SimpleDateFormat df   = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date             now  = df.parse(df.format(new Date()));
        Date             reg  = df.parse(StringUtil.printDate(date));
        long             l    = now.getTime() - reg.getTime();
        long             diff = l - hour * 60 * 60 * 1000;

        boolean yn = true;

        if (diff > 0) yn = false;

        return yn;
    }

    /**
     * 내용 : JSP select 옵션용 년도 뽑기 시작년도값을 넣으면 현재 년도까지 값이 나온다.
     * 작성자 : 김문석
     * 작성시간  : 2013. 4. 23.
     * method_name : getYearsForSelectOption
     *
     * @param startYear
     * @return
     */
    public static List<String> getYearsForSelectOption(int startYear) {
        List<String> ret = new ArrayList<String>();

        Calendar today   = Calendar.getInstance();
        String   strYear = String.valueOf(today.get(Calendar.YEAR));
        for (int i = startYear; Integer.parseInt(strYear) >= i; i++) {
            ret.add(String.valueOf(i));
        }
        Collections.reverse(ret);
        return ret;
    }

    public static List<String> getMonthForSelectOption() {
        List<String> ret = new ArrayList<String>();
        for (int i = 1; 12 >= i; i++) {
            ret.add(Integer.toString(i));
        }
        return ret;
    }

    public static List<String> getDaysForSelectOption() {
        List<String> ret = new ArrayList<String>();
        for (int i = 1; 31 >= i; i++) {
            ret.add(Integer.toString(i));
        }
        return ret;
    }

    static int remainSeconds() {
        Calendar one = Calendar.getInstance();
        Calendar two = Calendar.getInstance();

        Date now = new Date();
        one.setTime(now);
        two.add(Calendar.DATE, 1); //하루를 더한다.
        two.set(Calendar.HOUR, 0);
        two.set(Calendar.MINUTE, 0);
        two.set(Calendar.SECOND, 0);
        two.set(Calendar.MILLISECOND, 0);

        return (int)((two.getTimeInMillis() - one.getTimeInMillis()) / 1000);
    }
}
