package com.opus.squadscheme.api.v1.services;

import com.opus.squadscheme.api.v1.repositories.TrainingRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TrainingServiceImplTest {

    @Mock
    private TrainingRepo trainingRepo;
    @InjectMocks
    private TrainingServiceImpl trainingService;]

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
}