package com.opus.squadscheme.api.v1.services;

import com.opus.squadscheme.api.v1.domain.Training;

import java.util.List;

public interface TrainingService {
    public Training create(Training trainingData);

    public Training findById(Integer trainingId);

    public List<Training> findAll();

    public Training update(Training trainingData);

    public void delete(Integer trainingId);
}
