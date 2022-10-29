package com.icops.DaraManagement.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum AttendanceDays {
    MONDAY("MON"),
    TUESDAY("TUE"),
    WEDNESDAY("WED"),
    THURSDAY("THUR"),
    FRIDAY("FRI"),
    SATURDAY("SAT"),
    SUNDAY("SUN");

    private final String value;

    AttendanceDays(String v) { value = v; }

    @JsonValue
    public String value() { return value; }

    @Override
    public String toString() { return value; }
}
