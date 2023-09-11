package com.z5.zcms.util;

import java.util.concurrent.ThreadLocalRandom;

public class Generator {
    public static int random(int min, int max) {
        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String randomString(int min, int max) {
        return Integer.toString(random(min, max));
    }
}
