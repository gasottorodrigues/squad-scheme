package com.opus.squadscheme.api.v1.services;

import com.opus.squadscheme.api.v1.domain.Schedule;

import java.util.List;

public interface ScheduleService {
    public Schedule create(Schedule scheduleData);

    public Schedule findById(Integer scheduleId);
    public List<Schedule> findAll();

    public Schedule update(Schedule scheduleData);
    public void delete(Integer scheduleId);
}
