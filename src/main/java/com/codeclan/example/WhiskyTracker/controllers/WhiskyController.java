package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/whiskeys")
    public ResponseEntity<List<Whisky>> getAllWhiskeys(){
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/whiskeys/{id}")
    public ResponseEntity getWhisky(@PathVariable Long id){
        return new ResponseEntity<>(whiskyRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/whiskeys/{year}")
    public ResponseEntity<List<Whisky>> findWhiskeysByYear(@PathVariable int year){
        return new ResponseEntity<>(whiskyRepository.findByYear(year), HttpStatus.OK);

    }

    //    Get all the whisky from a particular distillery that's a specific age

    @GetMapping(value = "/whiskies/{distillery}/{year}")
    public ResponseEntity<List<Whisky>> findWhiskeysByDistilleryYear(@PathVariable Distillery distillery, @PathVariable int year){
        return new ResponseEntity<>(whiskyRepository.findByYear(year), HttpStatus.OK);
    }


}
