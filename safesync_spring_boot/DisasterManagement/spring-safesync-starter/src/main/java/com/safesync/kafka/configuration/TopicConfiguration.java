package com.safesync.kafka.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicConfiguration {

    @Bean
    public NewTopic hospitalTopic(){
        return TopicBuilder.name("hospital")
                .build();
    }
    @Bean
    public NewTopic policeStationTopic() {
        return TopicBuilder.name("police")
                .build();
    }
    @Bean
    public NewTopic ngoTopic()
    {
        return TopicBuilder.name("ngo")
                .build();
    }
    @Bean
    public NewTopic firebrigadeTopic()
    {
        return TopicBuilder.name("firebrigade")
                .build();
    }
}
