package com.icops.DaraManagement.converter.enumtostring;

import com.icops.DaraManagement.model.enums.RecitationLevel;
import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Optional;

@Component
@Converter(autoApply = true)
public class RecitationLevelConverter implements AttributeConverter<RecitationLevel, String> {
    @Override
    public String convertToDatabaseColumn(final RecitationLevel attribute) {
        return Optional.ofNullable(attribute).map(RecitationLevel::value).orElse(null);
    }

    @Override
    public RecitationLevel convertToEntityAttribute(final String dbData) {
        return RecitationLevel.decode(dbData);
    }
}
