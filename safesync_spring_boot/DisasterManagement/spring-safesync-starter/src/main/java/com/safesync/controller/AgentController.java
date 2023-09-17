package com.safesync.controller;

import com.safesync.model.Instances;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/agent")
public class AgentController {
    private final Map<Integer, Sinks.Many<ServerSentEvent<Instances>>> clients = new ConcurrentHashMap<>();
    @GetMapping(value = "/instances/{id}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<ServerSentEvent<Instances>> subscribeHospital(@PathVariable("hospital-id") Integer clientId)
    {
        Sinks.Many<ServerSentEvent<Instances>> sink = Sinks.many().unicast().onBackpressureBuffer();
        clients.put(clientId, sink);
        Flux<ServerSentEvent<Instances>> flux = sink.asFlux();
        flux.doFinally(signalType -> clients.remove(clientId));
        return flux;
    }
    public void sendEventToClient(Integer clientId, Instances data) {
        Sinks.Many<ServerSentEvent<Instances>> sink = clients.get(clientId);
        if (sink != null) {
            ServerSentEvent<Instances> event = ServerSentEvent.<Instances>builder()
                    .data(data)
                    .build();
            sink.tryEmitNext(event);
        }
    }
}
