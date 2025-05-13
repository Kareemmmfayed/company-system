package com.megadev.hr.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity(name = "vacation-request")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VacationRequest {

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

    private VacationRequestStatus status = VacationRequestStatus.pending;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;
}
