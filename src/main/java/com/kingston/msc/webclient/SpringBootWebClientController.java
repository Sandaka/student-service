package com.kingston.msc.webclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by Sandaka Wijesinghe.
 * Date: 6/26/22
 */
@RestController
@RequestMapping("/sts")
public class SpringBootWebClientController {

    @Autowired
    WebClient webClient;

    @Autowired
    WebClient createWebClientCourseProvider;

    @SuppressWarnings({"unchecked", "rawtypes"})
    @GetMapping("/v1/post/{id}")
    public ResponseEntity<Mono<Post>> getPost(@PathVariable String id) {

        Mono<Post> postMono = webClient.get()
                .uri("/posts/" + id)
                .retrieve()
                .bodyToMono(Post.class);

        return new ResponseEntity(postMono, HttpStatus.OK);
    }

    @GetMapping("/v1/posts")
    public ResponseEntity<Flux<Post>> getPosts(){
        Flux<Post> postFlux = webClient.get()
                .uri("/posts")
                .retrieve()
                .bodyToFlux(Post.class);

        return new ResponseEntity(postFlux, HttpStatus.OK);
    }

    @GetMapping("/v1/string")
    public Mono<String> getString(){
       Mono<String> value = createWebClientCourseProvider.get()
                .uri("/cps/course/coursetest")
                .retrieve()
                .bodyToMono(String.class);
       return value;
    }

    @PostMapping(path = "/v1/post", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Post> createPost(@RequestBody Post post) {

        return webClient.post()
                .uri("/posts")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(BodyInserters.fromValue(post))
                .retrieve()
                .bodyToMono(Post.class);
    }

    @PutMapping(path = "/v1/post", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Post> updatePost(@RequestBody Post post) {

        return webClient.put()
                .uri("/posts/1")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(BodyInserters.fromValue(post))
                .retrieve()
                .bodyToMono(Post.class);
    }

    @DeleteMapping(path = "/v1/post/{id}")
    public Mono<Post> deletePost(@PathVariable String id) {

        return webClient.delete()
                .uri("/posts/" + id)
                .retrieve()
                .bodyToMono(Post.class);
    }
}
