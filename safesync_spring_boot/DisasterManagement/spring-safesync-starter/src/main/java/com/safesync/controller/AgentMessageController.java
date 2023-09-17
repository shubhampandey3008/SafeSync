package com.safesync.controller;

import com.safesync.dto.Firebrigade;
import com.safesync.dto.Hospital;
import com.safesync.dto.Ngo;
import com.safesync.dto.Police;
import com.safesync.model.AgentMessage;
import com.safesync.repository.FirebrigadeRepository;
import com.safesync.repository.HospitalRepository;
import com.safesync.repository.NgoRepository;
import com.safesync.repository.PoliceRepository;
import com.safesync.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/agent-message")
public class AgentMessageController {

    @Autowired
    FileStorageService fileStorageService;
    @Autowired
    private HospitalRepository hospitalRepository;
    @Autowired
    private PoliceRepository policeRepository;
    @Autowired
    private NgoRepository ngoRepository;
    @Autowired
    private FirebrigadeRepository firebrigadeRepository;
    @PostMapping("/send-message")
    public ResponseEntity<?> sendMessage(@RequestBody AgentMessage agentMessage)
    {

        return new ResponseEntity<>(agentMessage, HttpStatus.OK);
    }
    @PostMapping("/hospital/assign")
    public ResponseEntity<?> assignHospitalResources(@RequestBody Hospital hospital) throws IOException {
        Hospital actualHospital = hospitalRepository.findById(hospital.getId()).get();
        actualHospital.setAmbulances(actualHospital.getAmbulances()-hospital.getAmbulances());
        actualHospital.setBeds(actualHospital.getBeds()-hospital.getBeds());
        actualHospital.setIcus(actualHospital.getIcus()-hospital.getIcus());
        actualHospital.setDoctors(actualHospital.getDoctors()-hospital.getDoctors());
        actualHospital.setNurses(actualHospital.getNurses()-hospital.getNurses());
        hospital = hospitalRepository.save(actualHospital);
        fileStorageService.updateFile();
        return new ResponseEntity<>(hospital, HttpStatus.OK);
    }
    @PostMapping("/hospital/free")
    public ResponseEntity<?> freeHospitalResources(@RequestBody Hospital hospital) throws IOException {
        Hospital actualHospital = hospitalRepository.findById(hospital.getId()).get();
        actualHospital.setAmbulances(actualHospital.getAmbulances()+hospital.getAmbulances());
        actualHospital.setBeds(actualHospital.getBeds()+hospital.getBeds());
        actualHospital.setIcus(actualHospital.getIcus()+hospital.getIcus());
        actualHospital.setDoctors(actualHospital.getDoctors()+hospital.getDoctors());
        actualHospital.setNurses(actualHospital.getNurses()+hospital.getNurses());
        hospital = hospitalRepository.save(actualHospital);
        fileStorageService.updateFile();
        return new ResponseEntity<>(hospital, HttpStatus.OK);
    }
    @PostMapping("/police/assign")
    public ResponseEntity<?> assignPoliceResources(@RequestBody Police police) throws IOException {
        Police actualPolice = policeRepository.findById(police.getId()).get();
        actualPolice.setPoliceVan(actualPolice.getPoliceVan()-police.getPoliceVan());
        actualPolice.setPersonnel(actualPolice.getPersonnel()-police.getPersonnel());
        actualPolice.setPatrolVehicle(actualPolice.getPatrolVehicle()-police.getPatrolVehicle());
        police = policeRepository.save(actualPolice);
        fileStorageService.updateFile();
        return new ResponseEntity<>(police, HttpStatus.OK);
    }
    @PostMapping("/police/free")
    public ResponseEntity<?> freePoliceResources(@RequestBody Police police) throws IOException {
        Police actualPolice = policeRepository.findById(police.getId()).get();
        actualPolice.setPoliceVan(actualPolice.getPoliceVan()+police.getPoliceVan());
        actualPolice.setPersonnel(actualPolice.getPersonnel()+police.getPersonnel());
        actualPolice.setPatrolVehicle(actualPolice.getPatrolVehicle()+police.getPatrolVehicle());
        police = policeRepository.save(actualPolice);
        fileStorageService.updateFile();
        return new ResponseEntity<>(police, HttpStatus.OK);
    }
    @PostMapping("/ngo/assign")
    public ResponseEntity<?> assignNgoResources(@RequestBody Ngo ngo) throws IOException {
        Ngo actualNgo = ngoRepository.findById(ngo.getId()).get();
        actualNgo.setFoodPackets(actualNgo.getFoodPackets()-ngo.getFoodPackets());
        actualNgo.setTents(actualNgo.getTents()-ngo.getTents());
        actualNgo.setVolunteers(actualNgo.getVolunteers()-ngo.getVolunteers());
        actualNgo.setWaterBottles(actualNgo.getWaterBottles()- ngo.getWaterBottles());
        ngo = ngoRepository.save(actualNgo);
        fileStorageService.updateFile();
        return new ResponseEntity<>(ngo, HttpStatus.OK);
    }
    @PostMapping("/ngo/free")
    public ResponseEntity<?> freeNgoResources(@RequestBody Ngo ngo) throws IOException {
        Ngo actualNgo = ngoRepository.findById(ngo.getId()).get();
        actualNgo.setFoodPackets(actualNgo.getFoodPackets()+ngo.getFoodPackets());
        actualNgo.setTents(actualNgo.getTents()+ngo.getTents());
        actualNgo.setVolunteers(actualNgo.getVolunteers()+ngo.getVolunteers());
        actualNgo.setWaterBottles(actualNgo.getWaterBottles()+ngo.getWaterBottles());
        ngo = ngoRepository.save(actualNgo);
        fileStorageService.updateFile();
        return new ResponseEntity<>(ngo, HttpStatus.OK);
    }
    @PostMapping("/firebrigade/assign")
    public ResponseEntity<?> assignFireResources(@RequestBody Firebrigade firebrigade) throws IOException {
        Firebrigade actual = firebrigadeRepository.findById(firebrigade.getId()).get();
        actual.setFireFightingVehicle(actual.getFireFightingVehicle()-firebrigade.getFireFightingVehicle());
        actual.setRescueVehicle(actual.getRescueVehicle()-firebrigade.getRescueVehicle());
        actual.setPersonnel(actual.getPersonnel()-firebrigade.getPersonnel());
        actual.setSearchAndRescueTeam(actual.getSearchAndRescueTeam()-firebrigade.getSearchAndRescueTeam());
        firebrigade = firebrigadeRepository.save(actual);
        fileStorageService.updateFile();
        return new ResponseEntity<>(firebrigade, HttpStatus.OK);
    }
    @PostMapping("/firebrigade/free")
    public ResponseEntity<?> freeFireResources(@RequestBody Firebrigade firebrigade) throws IOException {
        Firebrigade actual = firebrigadeRepository.findById(firebrigade.getId()).get();
        actual.setFireFightingVehicle(actual.getFireFightingVehicle()+firebrigade.getFireFightingVehicle());
        actual.setRescueVehicle(actual.getRescueVehicle()+firebrigade.getRescueVehicle());
        actual.setPersonnel(actual.getPersonnel()+firebrigade.getPersonnel());
        actual.setSearchAndRescueTeam(actual.getSearchAndRescueTeam()+firebrigade.getSearchAndRescueTeam());
        firebrigade = firebrigadeRepository.save(actual);
        fileStorageService.updateFile();
        return new ResponseEntity<>(firebrigade, HttpStatus.OK);
    }
}
