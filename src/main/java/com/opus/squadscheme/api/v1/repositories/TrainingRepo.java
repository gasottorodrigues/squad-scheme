package com.opus.squadscheme.api.v1.repositories;

import com.opus.squadscheme.api.v1.domain.Training;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingRepo extends JpaRepository<Training,Integer> {
}
