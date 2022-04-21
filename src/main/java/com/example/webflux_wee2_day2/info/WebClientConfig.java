package com.example.webflux_wee2_day2.info;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


@Configuration
 public class WebClientConfig {

    @Bean
    public RouterFunction<ServerResponse> route(InfoHandler handler) {
        return RouterFunctions.route(
                RequestPredicates.GET("/info").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), handler::getByJob);
    }

}
