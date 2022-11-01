package com.example.orderbox2.model.enums;

import org.springframework.util.StringUtils;

public enum OrderType {

    STOP("STOP"),
    LIMIT("LIMIT"),
    MARKET("MARKET");
    public final String name;

    OrderType(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }


    public static OrderType value(String name) {
        if (!StringUtils.hasText(name)) {
            return null;
        }

        try {
            return OrderType.valueOf(name.toUpperCase());
        } catch (IllegalArgumentException ex) {
            return null;
        }
    }

    }
