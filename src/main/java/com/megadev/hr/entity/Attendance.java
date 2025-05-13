package com.megadev.hr.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity(name = "attendance")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "day", nullable = false)
    private LocalDate day;

    @Column(name = "checkIn", nullable = false)
    private LocalDate checkIn;

    @Column(name = "checkOut", nullable = false)
    private LocalDate checkOut;

    @Column(name = "status", nullable = false)
    private WorkType status;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;
}
