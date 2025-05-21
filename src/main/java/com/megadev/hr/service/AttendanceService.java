package com.megadev.hr.service;

import com.megadev.hr.dto.attendance.AttendanceReportDTO;
import com.megadev.hr.dto.attendance.AttendanceResponseDTO;
import com.megadev.hr.dto.attendance.CheckInDTO;
import com.megadev.hr.dto.attendance.CheckOutDTO;
import com.megadev.hr.entity.Attendance;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface AttendanceService {
    List<AttendanceReportDTO> getAttendanceReport(LocalDate day);
    String CheckInEmployee(CheckInDTO checkInDTO);
    String PartiallyUpdateAttendance(Long id, Map<String, Object> updates);
}