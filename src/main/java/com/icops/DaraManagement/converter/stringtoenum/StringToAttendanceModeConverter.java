package com.icops.DaraManagement.converter.stringtoenum;

import com.icops.DaraManagement.converter.RequestParameterConverter;
import com.icops.DaraManagement.model.enums.AttendanceMode;
import com.icops.DaraManagement.model.enums.RecitationLevel;
import org.springframework.core.convert.converter.Converter;

@RequestParameterConverter
public class StringToAttendanceModeConverter implements Converter<String, AttendanceMode> {
    @Override
    public AttendanceMode convert(String source) {
        return AttendanceMode.decode(source);
    }
}
