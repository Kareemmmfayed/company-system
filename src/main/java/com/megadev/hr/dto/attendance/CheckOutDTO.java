package com.megadev.hr.dto.attendance;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@NoArgsConstructor
@Getter
@Setter
public class CheckOutDTO {

    @NotNull(message = "You must provide the check-out time!")
    private LocalTime checkOut;

    @NotNull(message = "You must provide the Attendance's ID!")
    private Long attendanceId;
}