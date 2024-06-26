package com.myblog2.service.impl;

import com.myblog2.entity.Post;
import com.myblog2.payload.PostDto;
import com.myblog2.repository.PostRepository;
import com.myblog2.service.PostService;
import org.springframework.stereotype.Service;


@Service
public class PostServiceImpl implements PostService {


    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {

        Post post = new Post();
        post.setId(postDto.getId());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        post.setTitle(postDto.getTitle());

        Post updatedPost = postRepository.save(post);


        PostDto dto = new PostDto();
        dto.setId(post.getId());
        dto.setDescription(post.getDescription());
        dto.setContent(post.getContent());
        dto.setTitle(post.getTitle());


        return dto;
    }

    @Override
    public void deletePostById(int postId) {
        postRepository.deleteById((long)postId);

    }
}
