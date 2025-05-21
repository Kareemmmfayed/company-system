package com.megadev.hr.dto.employee;

import com.megadev.hr.enums.JobType;
import com.megadev.hr.enums.Position;
import com.megadev.hr.enums.Type;

import java.math.BigDecimal;

public interface GetEmployeeDTO {
    Long getId();
    String getName();
    String getPhoneNumber();
    String getEmail();
    Position getPosition();
    Type getType();
    JobType getJobType();
    String getHomeTown();
    BigDecimal getSalary();
}
