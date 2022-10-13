package com.icops.DaraManagement.converter.enumtostring;

import com.icops.DaraManagement.model.enums.AmPm;
import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Optional;

@Component
@Converter(autoApply = true)
public class AmPmConverter implements AttributeConverter<AmPm, String> {
    @Override
    public String convertToDatabaseColumn(final AmPm attribute) {
        return Optional.ofNullable(attribute).map(AmPm::value).orElse(null);
    }

    @Override
    public AmPm convertToEntityAttribute(final String dbData) {
        return AmPm.decode(dbData);
    }
}
