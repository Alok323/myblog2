package com.myblog2.service;

import com.myblog2.payload.PostDto;

public interface PostService {

   public  PostDto createPost(PostDto postDto);

   void deletePostById(int postId);
}
