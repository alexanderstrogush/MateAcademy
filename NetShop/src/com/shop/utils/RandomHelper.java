package com.shop.utils;

import java.nio.charset.Charset;
import java.util.Random;

public class RandomHelper {

    public static String getRandomString() {
        Random random = new Random();
        return String.valueOf(random.nextInt(9999 - 1000 + 1) + 1000);
    }

    public static String getRandomSalt() {
        byte[] array = new byte[6];
        new Random().nextBytes(array);

        return new String(array, Charset.forName("UTF-8"));
    }
}
