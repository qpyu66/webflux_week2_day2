package com.example.webflux_wee2_day2.info;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.HashMap;

@Component
public class InfoHandler {
    private HashMap<Object, Object> result = new HashMap<>();
    private Mono<HashMap<Object, Object>> mapper = Mono.just(result);

    public Mono<ServerResponse> getByJob(ServerRequest request) {
        System.out.println(request.getClass());
        String name = String.valueOf(request.queryParam("name"));
        System.out.println("name > "+name);
        result.put("job", name);
        mapper.subscribe( (arg)->{
            System.out.println(arg);
            System.out.println("request > "+request);
        });
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromProducer(mapper, HashMap.class));
    }

}
