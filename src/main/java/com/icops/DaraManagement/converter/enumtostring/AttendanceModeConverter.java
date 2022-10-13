package com.icops.DaraManagement.converter.enumtostring;

import com.icops.DaraManagement.model.enums.AttendanceMode;
import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Optional;

@Component
@Converter(autoApply = true)
public class AttendanceModeConverter implements AttributeConverter<AttendanceMode, String> {

    @Override
    public String convertToDatabaseColumn(final AttendanceMode attribute) {
        return Optional.ofNullable(attribute).map(AttendanceMode::value).orElse(null);
    }

    @Override
    public AttendanceMode convertToEntityAttribute(final String dbData) {
        return AttendanceMode.decode(dbData);
    }
}
