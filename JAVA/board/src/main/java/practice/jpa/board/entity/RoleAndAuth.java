package practice.jpa.board.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import practice.jpa.board.enumtype.RoleType;

@Entity
@Getter
@Builder
public class RoleAndAuth extends BaseEntity
{
    @Id
    @GeneratedValue
    @Column(name = "role_and_auth_pid")
    private Long pid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auth_pid")
    private Auth auth;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_pid")
    private Role role;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;
}
