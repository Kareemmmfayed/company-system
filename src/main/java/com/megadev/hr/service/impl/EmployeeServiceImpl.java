package com.megadev.hr.service.impl;

import com.megadev.hr.dto.employee.AddEmployeeRequestDTO;
import com.megadev.hr.dto.employee.AddEmployeeResponseDTO;
import com.megadev.hr.dto.employee.GetEmployeeDTO;
import com.megadev.hr.entity.Employee;
import com.megadev.hr.exception.EmailIsNotAvailableException;
import com.megadev.hr.exception.PhoneNumberIsNotAvailableException;
import com.megadev.hr.repository.EmployeeRepository;
import com.megadev.hr.service.EmployeeService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public AddEmployeeResponseDTO addEmployee(AddEmployeeRequestDTO addEmployeeRequestDTO) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(addEmployeeRequestDTO, employee);

        checkIfPhoneNumberExists(employee);
        checkIfEmailExists(employee);

        Employee newEmp = employeeRepository.save(employee);
        AddEmployeeResponseDTO addEmployeeResponseDTO = new AddEmployeeResponseDTO();
        BeanUtils.copyProperties(newEmp, addEmployeeResponseDTO);
        return addEmployeeResponseDTO;
    }

    @Override
    @Transactional
    public List<GetEmployeeDTO> getEmployees() {
        return employeeRepository.findAllBy();
    }

    private void checkIfEmailExists(Employee employee) {
        Optional<Employee> theEmp = employeeRepository.findByEmail(employee.getEmail());
        if(theEmp.isPresent()) throw new EmailIsNotAvailableException("This email is not available!");
    }

    private void checkIfPhoneNumberExists(Employee employee) {
        Optional<Employee> theEmp = employeeRepository.findByPhoneNumber(employee.getPhoneNumber());
        if(theEmp.isPresent()) throw new PhoneNumberIsNotAvailableException("This phone number is not available!");
    }
}
