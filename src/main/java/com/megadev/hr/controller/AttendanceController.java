package com.megadev.hr.controller;

import com.megadev.hr.dto.attendance.AttendanceReportDTO;
import com.megadev.hr.dto.attendance.AttendanceResponseDTO;
import com.megadev.hr.dto.attendance.CheckInDTO;
import com.megadev.hr.dto.attendance.CheckOutDTO;
import com.megadev.hr.entity.Attendance;
import com.megadev.hr.service.AttendanceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AttendanceController {

    private final AttendanceService attendanceService;

    @GetMapping("/attendance-report")
    public ResponseEntity<List<AttendanceReportDTO>> attendance(@RequestParam(name = "day", required = true) LocalDate day) {
        return ResponseEntity.ok(attendanceService.getAttendanceReport(day));
    }

    @PostMapping("/check-in")
    public ResponseEntity<String> chickIn(@Valid @RequestBody CheckInDTO checkInDTO) {
        return ResponseEntity.ok(attendanceService.CheckInEmployee(checkInDTO));
    }


    @PatchMapping("/{id}")
    public ResponseEntity<String> updateAttendance(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        return ResponseEntity.ok(attendanceService.PartiallyUpdateAttendance(id, updates));
    }
}
