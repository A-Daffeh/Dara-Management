package com.icops.DaraManagement.model;

import com.icops.DaraManagement.model.enums.AmPm;
import com.icops.DaraManagement.model.enums.AttendanceDays;
import com.icops.DaraManagement.model.enums.AttendanceMode;
import com.icops.DaraManagement.model.enums.RecitationLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Slf4j
@Entity
public class Student extends PersonDetails {

    @Column(columnDefinition = "DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;

    private RecitationLevel recitationLevel;
    private AttendanceMode attendanceMode;

    private int startTime;
    private AmPm startRange;

    private int endTime;
    private AmPm endRange;

    @ManyToMany
    private List<Parent> parents;

}
