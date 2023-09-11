package com.z5.zcms.util;

public class NumberUtil {

    public static double printPercent(int num, int total) {

        double percent = (Double.valueOf(num).doubleValue() / Double.valueOf(total).doubleValue()) * 100;
        percent = Math.round(percent * 100);
        percent = (percent) / 100;
        return percent;
    }

}
