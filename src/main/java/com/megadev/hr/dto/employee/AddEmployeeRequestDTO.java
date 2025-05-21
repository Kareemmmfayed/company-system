package com.megadev.hr.dto.employee;

import com.megadev.hr.enums.JobType;
import com.megadev.hr.enums.Position;
import com.megadev.hr.enums.Type;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddEmployeeRequestDTO {

    @NotNull(message = "You must provide the employee's full name!")
    @Size(min = 3, max = 50, message = "The employee's name must be between 3 and 50 characters!")
    private String name;

    @NotNull(message = "You must provide the employee's phone number!")
    @Size(min = 11, max = 11, message = "The phone number must be 11 characters!")
    private String phoneNumber;

    @NotNull(message = "You must provide the employee's email!")
    @Email(message = "The email is invalid")
    private String email;

    @NotNull(message = "You must provide the employee's home town!")
    @Size(min = 3, max = 15, message = "The employee's town must be between 3 and 15 characters!")
    private String homeTown;

    @NotNull(message = "You must provide the employee's hiring date!")
    @Past(message = "the date should be in the past!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate hiringTime;

    @NotNull(message = "You must provide the employee's salary!")
    @PositiveOrZero(message = "Salary cannot be negative")
    private BigDecimal salary;

    @NotNull(message = "You must provide the employee's job type!")
    private JobType jobType;

    @NotNull(message = "You must provide the employee's position!")
    private Position position;

    @NotNull(message = "You must provide the employee's type!")
    private Type type;
}
