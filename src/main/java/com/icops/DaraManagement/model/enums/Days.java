package com.icops.DaraManagement.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum Days {
    MONDAY("MON"),
    TUESDAY("TUE"),
    WEDNESDAY("WED"),
    THURSDAY("THUR"),
    FRIDAY("FRI"),
    SATURDAY("SAT"),
    SUNDAY("SUN");

    private final String value;

    Days(String v) { value = v; }

    @JsonValue
    public String value() { return value; }

    @JsonCreator
    public static Days decode(final String value) {
        return Stream.of(Days.values()).filter(targetEnum -> targetEnum.value.equals(value)).findFirst().orElse(null);
    }

    @Override
    public String toString() { return value; }
}
