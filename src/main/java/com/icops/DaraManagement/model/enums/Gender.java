package com.icops.DaraManagement.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum Gender {
    MALE("Male"), FEMALE("Female");

    private String value;
    Gender(String v) {
        value = v;
    }

    @JsonCreator
    public static Gender decode(final String value) {
        return Stream.of(Gender.values()).filter(targetEnum -> targetEnum.value.equals(value)).findFirst().orElse(null);
    }

    @JsonValue
    public String value() { return value; }

    @Override
    public String toString() { return value; }
}
