package com.icops.DaraManagement.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum AttendanceMode {
    ONLINE("online"), IN_PERSON("in-person");

    private final String value;

    AttendanceMode(String v) { value = v; }

    @JsonValue
    public String value() { return value; }

    @JsonCreator
    public static AttendanceMode decode(final String value) {
        return Stream.of(AttendanceMode.values()).filter(targetEnum -> targetEnum.value.equals(value)).findFirst().orElse(null);
    }

    @Override
    public String toString() { return value; }
}
