package com.springbootbasic.aggregation;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    @Column(name = "register_year")
    private Integer registerYear;

    @Column(name = "approval_year")
    private Integer approvalYear;

    @ManyToOne
    @JoinColumn(name = "machine_id")
    private Machine machine;

}