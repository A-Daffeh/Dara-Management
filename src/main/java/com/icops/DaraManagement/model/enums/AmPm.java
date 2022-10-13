package com.icops.DaraManagement.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum AmPm {
    AM("am"), PM("pm");

    private final String value;

    AmPm(String v) { value = v; }

    @JsonValue
    public String value() { return value; }

    @JsonCreator
    public static AmPm decode(final String value) {
        return Stream.of(AmPm.values()).filter(targetEnum -> targetEnum.value.equals(value)).findFirst().orElse(null);
    }

    @Override
    public String toString() { return value; }
}
