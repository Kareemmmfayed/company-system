package com.megadev.hr.dto.vacation;

import com.megadev.hr.enums.VacationRequestStatus;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddVacationRequestDTO {

    @NotNull(message = "You must provide the Vacation starting date!")
    @Future(message = "the date should be in the future!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fromDate;

    @NotNull(message = "You must provide the Vacation ending date!")
    @Past(message = "the date should be in the future!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate toDate;

    @NotNull(message = "You must provide the Employee's ID!")
    private Long employee_id;
}
