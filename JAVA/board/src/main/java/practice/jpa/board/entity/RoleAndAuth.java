package practice.jpa.board.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.auditing.AuditingHandler;
import practice.jpa.board.enumtype.RoleType;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    public void assignAuthRole(Auth auth)
    {
        this.auth = auth;
        auth.getRoleAndAuths().add(this);
    }

}
