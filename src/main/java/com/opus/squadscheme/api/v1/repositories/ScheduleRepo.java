package com.opus.squadscheme.api.v1.repositories;

import com.opus.squadscheme.api.v1.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepo extends JpaRepository<Schedule,Integer> {
}
