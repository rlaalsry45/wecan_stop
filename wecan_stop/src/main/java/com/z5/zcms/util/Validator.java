package com.z5.zcms.util;

import org.apache.commons.lang.StringUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public boolean match(String source, String regex) {
        if (StringUtils.isNotBlank(source)) {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(source);
            return m.matches();
        }
        return false;
    }

    public boolean url(String url) {
        String regex = "^(http:\\/\\/|https:\\/\\/)?(www.)?([a-zA-Z0-9]+).[a-zA-Z0-9]*.[a-z]{3}.?([a-z]+)?$";
        return match(url, regex);
    }

    public boolean email(String email) {
        String regex = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
        return match(email, regex);
    }

    public boolean image(String path) {
        Image image = null;
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException ignored) {
            // log the exception
            // re-throw if desired
        }
        return image != null;
    }

    public static String path(String pathname) {
        if (StringUtils.isNotBlank(pathname)) {
            return pathname.replaceAll("/+", "/").replaceAll("\\+", "\\").trim();
        }
        return pathname;
    }

    public static boolean isTrue(String value) {
        return StringUtils.isNotBlank(value) && StringUtils.equalsIgnoreCase(value.trim(), "true");
    }

}
