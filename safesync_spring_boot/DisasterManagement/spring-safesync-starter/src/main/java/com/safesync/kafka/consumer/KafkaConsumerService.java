package com.safesync.kafka.consumer;

import com.safesync.controller.AgentController;
import com.safesync.model.Instances;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    @Autowired
    AgentController agentController;

    @KafkaListener(topics = "hospital", groupId = "safesync")
    public void consumeHospital(Instances hospital) {
        agentController.sendEventToClient(hospital.getId(), hospital);
    }
    @KafkaListener(topics = "police", groupId = "safesync")
    public void consumePolice(Instances police)
    {
        agentController.sendEventToClient(police.getId(), police);
    }
    @KafkaListener(topics = "ngo", groupId = "safesync")
    public void consumeNgos(Instances ngo)
    {
        agentController.sendEventToClient(ngo.getId(), ngo);
    }
    @KafkaListener(topics = "firebrigade", groupId = "safesync")
    public  void consumeFirebrigade(Instances firebrigade)
    {
        agentController.sendEventToClient(firebrigade.getId(), firebrigade);
    }

}
