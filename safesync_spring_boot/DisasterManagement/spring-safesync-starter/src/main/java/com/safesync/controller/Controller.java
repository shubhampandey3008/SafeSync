package com.safesync.controller;

import com.safesync.dto.Firebrigade;
import com.safesync.dto.Hospital;
import com.safesync.dto.Ngo;
import com.safesync.dto.Police;
import com.safesync.repository.FirebrigadeRepository;
import com.safesync.repository.HospitalRepository;
import com.safesync.repository.NgoRepository;
import com.safesync.repository.PoliceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
@CrossOrigin(origins = "*")
@RestController
public class Controller {

    @Autowired
    HospitalRepository hospitalRepository;
    @Autowired
    NgoRepository ngoRepository;
    @Autowired
    FirebrigadeRepository firebrigadeRepository;
    @Autowired
    PoliceRepository policeRepository;

    @PostMapping("/save-hospital")
    public ResponseEntity<?> saveHospital(@RequestBody Hospital hospital)
    {
        hospitalRepository.save(hospital);
        return new ResponseEntity<>(hospital, HttpStatus.OK);
    }
    @PostMapping("/save-ngo")
    public ResponseEntity<?> saveNgo(@RequestBody Ngo ngo)
    {
        ngoRepository.save(ngo);
        return new ResponseEntity<>(ngo, HttpStatus.OK);
    }
    @PostMapping("/save-police")
    public ResponseEntity<?> savePolice(@RequestBody Police police)
    {
        policeRepository.save(police);
        return new ResponseEntity<>(police, HttpStatus.OK);
    }
    @PostMapping("/save-firebrigade")
    public ResponseEntity<?> saveFire(@RequestBody Firebrigade firebrigade)
    {
        firebrigadeRepository.save(firebrigade);
        return new ResponseEntity<>(firebrigade, HttpStatus.OK);
    }


}
