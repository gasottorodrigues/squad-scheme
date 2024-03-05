package com.opus.squadscheme.api.v1.controllers;

import com.opus.squadscheme.api.v1.domain.Schedule;
import com.opus.squadscheme.api.v1.services.ScheduleService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {
    private final ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        try{
            List<Schedule> res = scheduleService.findAll();

            return new ResponseEntity<>(res,HttpStatus.OK);

        }catch (EntityNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Schedule scheduleData){
        try{
            Schedule res = scheduleService.create(scheduleData);

            return new ResponseEntity<>(res,HttpStatus.CREATED);
        }catch (Exception e ){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Schedule scheduleData){
        try{
            Schedule res = scheduleService.update(scheduleData);

            return new ResponseEntity<>(res,HttpStatus.OK);
        }catch (EntityNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }catch (Exception e ){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{scheduleId}")
    public ResponseEntity<?> getById(@PathVariable Integer scheduleId){
        try{
            Schedule res = scheduleService.findById(scheduleId);

            return new ResponseEntity<>(res,HttpStatus.OK);

        }catch (EntityNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{scheduleId}")
    public ResponseEntity<?> delete(@PathVariable Integer scheduleId){
        try{
            scheduleService.delete(scheduleId);

            return new ResponseEntity<>(scheduleId + " excluído.",HttpStatus.OK);

        }catch (EntityNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
