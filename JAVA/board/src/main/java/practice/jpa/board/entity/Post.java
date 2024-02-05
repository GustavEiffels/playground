package practice.jpa.board.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
@Builder
public class Post extends BaseEntity
{
    @Id
    @GeneratedValue
    @Column(name = "post_pid")
    private Long pid;

    private String title;

    @Builder.Default
    private Integer view = 0;

    @Column(columnDefinition="TEXT")
    private String contents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auth_pid")
    private Auth auth;

}
