package com.icops.DaraManagement.converter.stringtoenum;


import com.icops.DaraManagement.converter.RequestParameterConverter;
import com.icops.DaraManagement.model.enums.Gender;
import org.springframework.core.convert.converter.Converter;

@RequestParameterConverter
public class StringToGenderConverter implements Converter<String, Gender> {
    @Override
    public Gender convert(String source) {
        return Gender.decode(source);
    }
}
