package com.z5.zcms.util;

import javax.servlet.http.HttpServletRequest;

public class IpUtil {

    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (!validate(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (!validate(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (!validate(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    private static boolean validate(String ip) {
        return ip != null && ip.length() != 0 && !"unkown".equalsIgnoreCase(ip) && ip.split("\\.").length == 4;
    }
}
