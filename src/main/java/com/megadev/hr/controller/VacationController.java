package com.megadev.hr.controller;

import com.megadev.hr.dto.vacation.AddVacationRequestDTO;
import com.megadev.hr.dto.vacation.AddVacationResponseDTO;
import com.megadev.hr.service.VacationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/vacation")
@RequiredArgsConstructor
public class VacationController {

    private final VacationService vacationService;

    @PostMapping
    public ResponseEntity<AddVacationResponseDTO> addVacationRequest(@RequestBody AddVacationRequestDTO addVacationRequestDTO) {
        return ResponseEntity.ok(vacationService.addVacationRequest(addVacationRequestDTO));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> addVacationRequest(@PathVariable Long id ,@RequestBody Map<String, Object> updates) {
        return ResponseEntity.ok(vacationService.updateVacation(id, updates));
    }
}
