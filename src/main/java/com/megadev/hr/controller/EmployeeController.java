package com.megadev.hr.controller;

import com.megadev.hr.dto.employee.AddEmployeeRequestDTO;
import com.megadev.hr.dto.employee.AddEmployeeResponseDTO;
import com.megadev.hr.dto.employee.GetEmployeeDTO;
import com.megadev.hr.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<AddEmployeeResponseDTO> addEmployee(@Valid @RequestBody AddEmployeeRequestDTO addEmployeeRequestDTO) {
        return ResponseEntity.ok(employeeService.addEmployee(addEmployeeRequestDTO));
    }

    @GetMapping
    public ResponseEntity<List<GetEmployeeDTO>> getEmployees () {
        return ResponseEntity.ok(employeeService.getEmployees());
    }
}
