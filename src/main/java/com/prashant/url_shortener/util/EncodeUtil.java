package com.prashant.url_shortener.util;

public class EncodeUtil {

    private static final String BASE62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int SHORT_URL_LENGTH = 7;
    public static String encode(int num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(BASE62.charAt(num % BASE62.length()));
            num /= BASE62.length();
        }

        while (sb.length() < SHORT_URL_LENGTH) {
            sb.append('0');
        }

        return sb.reverse().toString();
    }
}
