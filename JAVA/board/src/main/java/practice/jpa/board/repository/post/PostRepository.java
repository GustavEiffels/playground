package practice.jpa.board.repository.post;


import org.springframework.data.jpa.repository.JpaRepository;
import practice.jpa.board.entity.Post;

public interface PostRepository extends JpaRepository<Post,Long> {
}
