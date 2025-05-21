package com.megadev.hr.repository;

import com.megadev.hr.dto.employee.GetEmployeeDTO;
import com.megadev.hr.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByPhoneNumber(String phoneNumber);
    Optional<Employee> findByEmail(String email);
    List<GetEmployeeDTO> findAllBy();
}