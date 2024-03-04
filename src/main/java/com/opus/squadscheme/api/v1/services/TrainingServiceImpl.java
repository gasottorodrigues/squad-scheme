package com.opus.squadscheme.api.v1.services;

import com.opus.squadscheme.api.v1.domain.Training;
import com.opus.squadscheme.api.v1.exceptions.BadRiskOfInjuryException;
import com.opus.squadscheme.api.v1.repositories.TrainingRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainingServiceImpl implements TrainingService{
    private final TrainingRepo trainingRepo;

    @Autowired
    public TrainingServiceImpl(TrainingRepo trainingRepo) {
        this.trainingRepo = trainingRepo;
    }

    @Override
    public Training create(Training trainingData) {
        trainingData.setId(0);

        if(trainingData.getRiskOfInjury() > 10 || trainingData.getRiskOfInjury() < 1){
            throw new BadRiskOfInjuryException("O risco de lesão deve ser entre 1 e 10");
        }

        return trainingRepo.save(trainingData);
    }
    @Override
    public Training findById(Integer trainingId) {
        Optional<Training> training = trainingRepo.findById(trainingId);

        return training.orElseThrow(()-> new EntityNotFoundException("Treino com id "+ trainingId + " não foi encontrado"));
    }

    @Override
    public List<Training> findAll(){
        List<Training> trainingList = trainingRepo.findAll();

        if(trainingList.isEmpty())
            throw new EntityNotFoundException("Não há treinos na base.");

        return trainingList;
    }

    @Override
    public Training update(Training trainingData) {
        if(!trainingRepo.existsById(trainingData.getId())){
            throw new EntityNotFoundException("Treino editado não foi encontrado");
        }

        if(trainingData.getRiskOfInjury() > 10 || trainingData.getRiskOfInjury() < 1){
            throw new BadRiskOfInjuryException("O risco de lesão deve ser entre 1 e 10");
        }

        return trainingRepo.save(trainingData);
    }

    @Override
    public void delete(Integer trainingId) {
        if(!trainingRepo.existsById(trainingId)){
            throw new EntityNotFoundException("Treino editado não foi encontrado");
        }

        trainingRepo.deleteById(trainingId);
    }


}
