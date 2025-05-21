package com.megadev.hr.entity;

import com.megadev.hr.enums.VacationRequestStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Vacations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "from", nullable = false)
    private LocalDate from;

    @Column(name = "to", nullable = false)
    private LocalDate to;

    @Column(name = "length", nullable = false)
    private int length;

    @Column(name = "status", nullable = false)
    private VacationRequestStatus status = VacationRequestStatus.PENDING;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

}
