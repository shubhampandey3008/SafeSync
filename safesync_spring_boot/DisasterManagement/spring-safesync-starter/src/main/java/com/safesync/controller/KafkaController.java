package com.safesync.controller;

import com.safesync.kafka.producer.KafkaProducerService;
import com.safesync.model.Instances;
import com.safesync.model.PayLoad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/safeSync")
public class KafkaController {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @PostMapping("/kafka/produce")
    public ResponseEntity<?> produce(@RequestBody PayLoad payLoad)
    {
        List<Instances> instancesList = payLoad.getInstances();
        for(Instances instance: instancesList)
        {
            if(instance.getType().equalsIgnoreCase("hospital"))
            {
                kafkaProducerService.sendToHospital(instance);
            } else if (instance.getType().equalsIgnoreCase("police")) {
                kafkaProducerService.sendToPolice((instance));
            } else if (instance.getType().equalsIgnoreCase("ngo")) {
                kafkaProducerService.sendToNgo(instance);
            }else {
                kafkaProducerService.sendToFirebrigade(instance);
            }
        }
        return new ResponseEntity<>("Successfully Published to Broker", HttpStatus.OK);
    }
}
