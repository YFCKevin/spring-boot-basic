package com.springbootbasic.aggregation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    @Column(name = "register_year")
    @CreatedDate
    private Integer registerYear;

    @Column(name = "approval_year")
    private Integer approvalYear;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "machine_id")
    private Machine machine;

    @LastModifiedDate
    private Integer modifiedDate;

}