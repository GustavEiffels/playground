package practice.jpa.board.service;


import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.jpa.board.controller.dto.PostDto;
import practice.jpa.board.entity.Post;
import practice.jpa.board.repository.post.PostRepository;

@Service
@RequiredArgsConstructor
public class CreateUpdatePostServiceImpl implements CreateUpdatePostService{

    private final PostRepository postRepository;

    private final EntityManager em;

    @Override
    public PostDto.CreatePost.Response createPost(PostDto.CreatePost.Request request)
    {
        Post post = Post.builder()
                .title(request.getTitle())
                .contents(request.getContent())
                .build();

        return  null;
    }
}
