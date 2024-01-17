package practice.jpa.board.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"loginId"}))
public class Auth extends BaseEntity
{

    @Id @GeneratedValue
    @Column(name = "auth_pid")
    private Long pid;

    private String loginId;
    private String password;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.DETACH)
    @JoinColumn(name = "refresh_token_pid")
    private RefreshToken refreshToken;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_pid")
    private Member member;

    public void linkMember(Member member)
    {
        this.member = member;
        member.getAuths().add(this);
    }

    @OneToMany(mappedBy = "auth")
    @Builder.Default
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "auth")
    @Builder.Default
    private List<RoleAndAuth> roleAndAuths = new ArrayList<>();
}
