package com.megadev.hr.dto.attendance;

import com.megadev.hr.enums.WorkType;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@Getter
@Setter
public class CheckInDTO {

    @NotNull(message = "You must provide the day!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate day;

    @NotNull(message = "You must provide the check-in time!")
    private LocalTime checkIn;

    @NotNull(message = "You must provide the check-in type!")
    private WorkType status;

    @NotNull(message = "You must provide the employee's ID!")
    private Long employeeId;
}
