package com.market.Ecommerceapp.utils;

import java.util.Date;

public final class SecurityConstants {
    private SecurityConstants(){}

    public static final String FAKE_USER = "root";
    public static final String FAKE_PASSWORD = "{noop}password";
    public static final long JWT_EXPIRATION = System.currentTimeMillis() + 1000 * 60 * 60 * 10;
    public static final String JWT_SECRET = "$3c4e7";
}
