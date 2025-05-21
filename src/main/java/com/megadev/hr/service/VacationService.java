package com.megadev.hr.service;

import com.megadev.hr.dto.vacation.AddVacationRequestDTO;
import com.megadev.hr.dto.vacation.AddVacationResponseDTO;

import java.util.Map;

public interface VacationService {
    AddVacationResponseDTO addVacationRequest(AddVacationRequestDTO addVacationRequestDTO);
    String updateVacation(Long id, Map<String, Object> updates);
}
