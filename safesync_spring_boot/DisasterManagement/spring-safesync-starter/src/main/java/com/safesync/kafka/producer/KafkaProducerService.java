package com.safesync.kafka.producer;

import com.safesync.model.Instances;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    @Autowired
    private KafkaTemplate<String, Instances> kafkaTemplate;

    public void sendToHospital(Instances hospital)
    {
        kafkaTemplate.send("hospital", hospital);
    }
    public void sendToPolice(Instances police)
    {
        kafkaTemplate.send("police", police);
    }
    public void sendToNgo(Instances ngo)
    {
        kafkaTemplate.send("ngo", ngo);
    }
    public void sendToFirebrigade(Instances firebrigade)
    {
        kafkaTemplate.send("firebrigade", firebrigade);
    }
}
