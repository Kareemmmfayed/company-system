package com.megadev.hr.dto.attendance;

import com.megadev.hr.enums.WorkType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@Getter
@Setter
public class AttendanceResponseDTO {
    Long id;
    LocalDate day;
    LocalTime checkIn;
    LocalTime checkOut;
    WorkType status;
}
