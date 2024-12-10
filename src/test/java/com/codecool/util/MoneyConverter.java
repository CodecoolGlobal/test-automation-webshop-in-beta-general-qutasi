package com.codecool.util;

public class MoneyConverter {
    public static int asCents(String price) {
        return Integer.parseInt(price.replaceAll("[.,]", ""));
    }
}
