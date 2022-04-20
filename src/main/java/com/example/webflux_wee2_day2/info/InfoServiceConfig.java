package com.example.webflux_wee2_day2.info;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromFormData;

@Configuration
 public class InfoServiceConfig {

//    WebClient client = WebClient.create("http://localhost:8081");
@Bean
public RouterFunction<ServerResponse> route(InfoHandler handler) {
    return RouterFunctions.route(
            RequestPredicates.GET("/hello").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), handler::getByJob);
}

    WebClient webClient = WebClient.builder()
            .baseUrl("http://localhost:8080")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build();

    Mono<Void> result2 = webClient.post()
            .uri("/hello")
            .contentType(MediaType.APPLICATION_JSON)
            .body(fromFormData("job",""))
            .retrieve()
            .bodyToMono(Void.class);


}
