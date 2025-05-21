package com.megadev.hr.service.impl;

import com.megadev.hr.dto.vacation.AddVacationRequestDTO;
import com.megadev.hr.dto.vacation.AddVacationResponseDTO;
import com.megadev.hr.entity.Employee;
import com.megadev.hr.entity.Vacation;
import com.megadev.hr.enums.VacationRequestStatus;
import com.megadev.hr.enums.WorkType;
import com.megadev.hr.exception.ResourceNotFound;
import com.megadev.hr.repository.EmployeeRepository;
import com.megadev.hr.repository.VacationRepository;
import com.megadev.hr.service.VacationService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class VacationServiceImpl implements VacationService {

    private final VacationRepository vacationRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public AddVacationResponseDTO addVacationRequest(AddVacationRequestDTO addVacationRequestDTO) {
        Vacation vacation = new Vacation();
        Employee theEmp = findEmployeeById(addVacationRequestDTO.getEmployee_id());
        BeanUtils.copyProperties(addVacationRequestDTO, vacation);
        vacation.setEmployee(theEmp);
        vacationRepository.save(vacation);
        AddVacationResponseDTO addVacationResponseDTO = new AddVacationResponseDTO();
        addVacationResponseDTO.setMessage("Vacation request has been submitted successfully!");
        BeanUtils.copyProperties(vacation, addVacationResponseDTO);
        return addVacationResponseDTO;
    }

    @Override
    public String updateVacation(Long id, Map<String, Object> updates) {
        Vacation vacation = findVacationById(id);
        vacation.setStatus(VacationRequestStatus.valueOf(updates.get("status").toString()));
        vacationRepository.save(vacation);
        return "Vacation request status was updated successfully!";
    }

    private Vacation findVacationById(Long id) {
        return vacationRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Vacation with ID [ " + id + " ] is not found!"));
    }

    private Employee findEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFound("Employee with ID [ " + employeeId + " ] is not found!"));
    }
}
