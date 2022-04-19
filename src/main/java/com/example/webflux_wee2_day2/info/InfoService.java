package com.example.webflux_wee2_day2.info;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromFormData;

//@Configuration
@Service
public class InfoService {

//    WebClient client = WebClient.create("http://localhost:8081");

    WebClient webClient = WebClient.builder()
            .baseUrl("http://localhost:8081")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build();

    Mono<Void> result2 = webClient.post()
            .uri("/hello")
            .contentType(MediaType.APPLICATION_JSON)
            .body(fromFormData("job",""))
            .retrieve()
            .bodyToMono(Void.class);


}
