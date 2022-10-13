package com.icops.DaraManagement.converter.enumtostring;

import com.icops.DaraManagement.model.enums.Gender;
import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Optional;

@Component
@Converter(autoApply = true)
public class GenderConverter implements AttributeConverter<Gender, String> {
    @Override
    public String convertToDatabaseColumn(final Gender attribute) {
        return Optional.ofNullable(attribute).map(Gender::value).orElse(null);
    }

    @Override
    public Gender convertToEntityAttribute(final String dbData) {
        return Gender.decode(dbData);
    }
}
