package com.opus.squadscheme.api.v1.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Training {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    private String name;
    private Integer riskOfInjury;

    @OneToMany(mappedBy = "trainingType", fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private List<Schedule> schedules;
}
