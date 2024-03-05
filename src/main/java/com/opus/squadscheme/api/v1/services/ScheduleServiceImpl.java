package com.opus.squadscheme.api.v1.services;

import com.opus.squadscheme.api.v1.domain.Schedule;
import com.opus.squadscheme.api.v1.repositories.ScheduleRepo;
import com.opus.squadscheme.api.v1.repositories.TrainingRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleServiceImpl implements ScheduleService{
    private final ScheduleRepo scheduleRepo;
    private final TrainingRepo trainingRepo;

    @Autowired
    public ScheduleServiceImpl(ScheduleRepo scheduleRepo, TrainingRepo trainingRepo) {
        this.scheduleRepo = scheduleRepo;
        this.trainingRepo = trainingRepo;
    }

    @Override
    public Schedule create(Schedule scheduleData) {
        scheduleData.setId(0);

        if(scheduleData.getTrainingType() == null || !trainingRepo.existsById(scheduleData.getTrainingType().getId())){
            throw new EntityNotFoundException("O treino a ser agendado não existe.");
        }

        return scheduleRepo.save(scheduleData);

    }

    @Override
    public Schedule findById(Integer scheduleId) {
        Optional<Schedule> schedule = scheduleRepo.findById(scheduleId);
        return schedule.orElseThrow(()-> new EntityNotFoundException("Agenda de id" + scheduleId + " não existe"));
    }

    @Override
    public List<Schedule> findAll() {

        List<Schedule> scheduleList = scheduleRepo.findAll();

        if(scheduleList.isEmpty()){
            throw new EntityNotFoundException("Não há treinos agendados.");
        }

        return scheduleList;
    }

    @Override
    public Schedule update(Schedule scheduleData) {
        if(!scheduleRepo.existsById(scheduleData.getId())){
            throw new EntityNotFoundException("O agendamento editado não existe.");
        }
        if(scheduleData.getTrainingType() == null || !trainingRepo.existsById(scheduleData.getTrainingType().getId())){
            throw new EntityNotFoundException("O treino a ser agendado não existe.");
        }

        return scheduleRepo.save(scheduleData);
    }

    @Override
    public void delete(Integer scheduleId) {
        if(!scheduleRepo.existsById(scheduleId)){
            throw new EntityNotFoundException("O agendamento não existe.");
        }

        scheduleRepo.deleteById(scheduleId);
    }
}
