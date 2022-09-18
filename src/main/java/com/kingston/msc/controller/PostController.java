package com.kingston.msc.controller;

import com.kingston.msc.entity.Posts;
import com.kingston.msc.model.PostRegistrationStudent;
import com.kingston.msc.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Sandaka Wijesinghe.
 * Date: 9/10/22
 */
@RestController
@RequestMapping("/sts")
@Slf4j
public class PostController {

    @Autowired
    private PostService postService;


    @PostMapping("/question")
    public ResponseEntity<Posts> saveQuestion(@RequestBody PostRegistrationStudent postRegistrationStudent) {

        Posts posts = postService.savePost(postRegistrationStudent);
        return ResponseEntity.ok().body(posts);
    }

    @GetMapping("/questions")
    public ResponseEntity<List<PostRegistrationStudent>> getAllQuestions() {
        List<PostRegistrationStudent> list = postService.getAllPosts();
        return ResponseEntity.ok().body(list);
    }
}
