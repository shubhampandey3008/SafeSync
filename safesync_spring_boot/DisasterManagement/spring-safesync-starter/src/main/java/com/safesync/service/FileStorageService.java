package com.safesync.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.safesync.repository.FirebrigadeRepository;
import com.safesync.repository.HospitalRepository;
import com.safesync.repository.NgoRepository;
import com.safesync.repository.PoliceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
@Service
public class FileStorageService {
    @Value("${file.path}")
    private String path;

    @Autowired
    HospitalRepository hospitalRepository;
    @Autowired
    NgoRepository ngoRepository;
    @Autowired
    PoliceRepository policeRepository;
    @Autowired
    FirebrigadeRepository firebrigadeRepository;

    public void updateFile() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            ObjectMapper objectMapper = new ObjectMapper();

            writer.write("[");
            // Write Hospitals
            writer.write("{\"agent\":\"Hospitals\", \"instances\":");
            writer.write(objectMapper.writeValueAsString(hospitalRepository.findAll()));
            writer.write("},\n");

            // Write Fire Brigades
            writer.write("{\"agent\":\"Fire Brigades\", \"instances\":");
            writer.write(objectMapper.writeValueAsString(firebrigadeRepository.findAll()));
            writer.write("},\n");

            // Write Police Stations
            writer.write("{\"agent\":\"Police Stations\", \"instances\":");
            writer.write(objectMapper.writeValueAsString(policeRepository.findAll()));
            writer.write("},\n");

            // Write NGOs
            writer.write("{\"agent\":\"NGOs\", \"instances\":");
            writer.write(objectMapper.writeValueAsString(ngoRepository.findAll()));
            writer.write("}\n");
            writer.write("]");
        }
    }
}