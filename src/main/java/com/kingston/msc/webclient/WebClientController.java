package com.kingston.msc.webclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * Created by Sandaka Wijesinghe.
 * Date: 7/2/22
 */
@RestController
@RequestMapping("/api")
public class WebClientController {

    @Autowired
    private WebClient webClient;

    @GetMapping("/posts/{id}")
    public Mono <Post> getPost(@PathVariable String id) {

        return webClient.get()
                .uri("/question/{id}", id)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(Post.class);
    }

    @GetMapping("/posts")
    public Mono< String > getPosts() {

        return webClient.get()
                .uri("/question/")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(String.class);
    }

    @PostMapping("/customers")
    public Mono < String > createCustomer(final Post post) {

        return webClient.post()
                .uri("/question/")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(post), Post.class)
                .retrieve()
                .bodyToMono(String.class);
    }

}
