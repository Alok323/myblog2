package com.myblog2.controller;

import com.myblog2.payload.PostDto;
import com.myblog2.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {



    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    //http://localhost:8080/api/posts
    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {

        PostDto dto = postService.createPost(postDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @DeleteMapping("{postId}")
    public ResponseEntity<String>deletePostById(@PathVariable int postId){

        postService.deletePostById(postId);
        return  new ResponseEntity<>("Post is deleted with id: "+postId,HttpStatus.OK);

    }
}
