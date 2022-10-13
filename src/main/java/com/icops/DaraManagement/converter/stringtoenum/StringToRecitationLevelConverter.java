package com.icops.DaraManagement.converter.stringtoenum;

import com.icops.DaraManagement.converter.RequestParameterConverter;
import com.icops.DaraManagement.model.enums.RecitationLevel;
import org.springframework.core.convert.converter.Converter;

@RequestParameterConverter
public class StringToRecitationLevelConverter implements Converter<String, RecitationLevel> {
    @Override
    public RecitationLevel convert(String source) {
        return RecitationLevel.decode(source);
    }
}
