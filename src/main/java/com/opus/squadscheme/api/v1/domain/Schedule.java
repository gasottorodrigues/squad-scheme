package com.opus.squadscheme.api.v1.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data @EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Schedule {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;
    private LocalDate date;

    private PeriodType period;

    @ManyToOne(optional = false) @JoinColumn(name = "training_id", referencedColumnName = "id")
    private Training trainingType;
}
