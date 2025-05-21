package com.megadev.hr.dto.attendance;


import java.time.LocalTime;

public interface AttendanceReportDTO {
        String getName();
        String getPosition();
        LocalTime getCheckIn();
        LocalTime getCheckOut();
        String getWorkingHours();
        String getStatus();
}
