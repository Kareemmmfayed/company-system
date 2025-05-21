package com.megadev.hr.repository;

import com.megadev.hr.dto.attendance.AttendanceReportDTO;
import com.megadev.hr.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    @Query("""
    SELECT e.name AS name, e.position AS position, a.checkIn AS checkIn, a.checkOut AS checkOut, COALESCE(a.status, 'ABSENT') AS status
    FROM Employee e
    LEFT JOIN Attendance a
    ON a.employee.id = e.id AND a.day = ?1
    """)
    List<AttendanceReportDTO> findEmployeeAttendance(LocalDate day);

}