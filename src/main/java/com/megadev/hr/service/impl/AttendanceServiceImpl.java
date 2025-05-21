package com.megadev.hr.service.impl;

import com.megadev.hr.dto.attendance.AttendanceReportDTO;
import com.megadev.hr.dto.attendance.AttendanceResponseDTO;
import com.megadev.hr.dto.attendance.CheckInDTO;
import com.megadev.hr.dto.attendance.CheckOutDTO;
import com.megadev.hr.entity.Attendance;
import com.megadev.hr.entity.Employee;
import com.megadev.hr.enums.WorkType;
import com.megadev.hr.exception.ResourceNotFound;
import com.megadev.hr.repository.AttendanceRepository;
import com.megadev.hr.repository.EmployeeRepository;
import com.megadev.hr.service.AttendanceService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public List<AttendanceReportDTO> getAttendanceReport(LocalDate day) {
        return attendanceRepository.findEmployeeAttendance(day);
    }

    @Override
    @Transactional
    public String CheckInEmployee(CheckInDTO checkInDTO) {
        Attendance attendance = new Attendance();
        BeanUtils.copyProperties(checkInDTO, attendance);
        attendance.setEmployee(findEmployeeById(checkInDTO.getEmployeeId()));
        attendanceRepository.save(attendance);
        return "Employee was checked in successfully!";
    }

    @Override
    @Transactional
    public String PartiallyUpdateAttendance(Long id, Map<String, Object> updates) {
        Attendance attendance = findAttendanceById(id);

        if (updates.containsKey("checkIn")) attendance.setCheckIn(LocalTime.parse(updates.get("checkIn").toString()));

        if (updates.containsKey("checkOut")) attendance.setCheckOut(LocalTime.parse(updates.get("checkOut").toString()));

        if (updates.containsKey("status")) attendance.setStatus(WorkType.valueOf(updates.get("status").toString()));

        attendanceRepository.save(attendance);

        return "Updated successfully!";
    }

    private Attendance findAttendanceById(Long attendanceId) {
        return attendanceRepository.findById(attendanceId).orElseThrow(() -> new ResourceNotFound("Attendance with ID [ " + attendanceId + " ] is not found!"));
    }

    private Employee findEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFound("Employee with ID [ " + employeeId + " ] is not found!"));
    }
}
