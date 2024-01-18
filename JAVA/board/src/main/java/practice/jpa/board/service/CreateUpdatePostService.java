package practice.jpa.board.service;


import practice.jpa.board.controller.dto.PostDto;

public interface CreateUpdatePostService
{
    PostDto.CreatePost.Response createPost(PostDto.CreatePost.Request request);
}
