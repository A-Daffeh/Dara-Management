package com.icops.DaraManagement.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum RecitationLevel {
    BASICS("basics"),
    QURAN("quran");

    private final String value;

    RecitationLevel(String v) { value = v; }

    @JsonCreator
    public static RecitationLevel decode(final String value) {
        return Stream.of(RecitationLevel.values()).filter(targetEnum -> targetEnum.value.equals(value)).findFirst().orElse(null);
    }

    @JsonValue
    public String value() { return value; }

    @Override
    public String toString() { return value; }
}
