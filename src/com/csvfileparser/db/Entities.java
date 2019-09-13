package com.csvfileparser.db;

import java.util.Arrays;
import java.util.Optional;

public enum Entities {
    ORDER(100), PRODUCT(200), INVOICE(300);

    private int value;

    Entities(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Optional<Entities> get(int val) {
        return Arrays.stream(Entities.values())
                .filter(s -> s.value == val)
                .findFirst();
    }
}
