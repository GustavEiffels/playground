package practice.jpa.board.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
@Builder
public class RefreshToken extends BaseEntity
{
    @Id
    @GeneratedValue
    @Column(name = "refresh_token_pid")
    private Long pid;

    @OneToOne(mappedBy = "refreshToken")
    private Auth auth;

    private String refreshToken;
}
