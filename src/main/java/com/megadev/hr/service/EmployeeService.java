package com.megadev.hr.service;

import com.megadev.hr.dto.employee.AddEmployeeRequestDTO;
import com.megadev.hr.dto.employee.AddEmployeeResponseDTO;
import com.megadev.hr.dto.employee.GetEmployeeDTO;

import java.util.List;

public interface EmployeeService {
    AddEmployeeResponseDTO addEmployee(AddEmployeeRequestDTO addEmployeeRequestDTO);
    List<GetEmployeeDTO> getEmployees();
}
