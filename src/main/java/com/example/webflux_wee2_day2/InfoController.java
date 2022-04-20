package com.example.webflux_wee2_day2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Mono;

@RestController
public class InfoController {

    @GetMapping("/info")
    public Mono<String> doTest() {
        WebClient client = WebClient.create();
        return client.get()
                .uri("http://localhost:8080/hello")
                .retrieve()
                .bodyToMono(String.class);
    }


//    @RequestMapping(value="/info", method = RequestMethod.POST)
//    public Mono<String> setJob(ServerRequest request) {
//        String name = String.valueOf(request.queryParam("name"));
//        System.out.println("name"+name);
//
//        WebClient client = WebClient.create();
//        return client.get()
//                .uri("http://localhost:8080/hello")
//                .retrieve()
//                .bodyToMono(String.class);

//    }


}
