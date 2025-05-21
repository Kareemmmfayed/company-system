package com.megadev.hr.dto.employee;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class AddEmployeeResponseDTO {
    private Long id;
    private String name;
}
