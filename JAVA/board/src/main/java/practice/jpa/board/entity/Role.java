package practice.jpa.board.entity;

import jakarta.persistence.*;
import lombok.*;
import practice.jpa.board.enumtype.RoleType;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Role extends BaseEntity
{
    @Id
    @GeneratedValue
    @Column(name = "role_pid")
    private Long pid;

    @Enumerated(EnumType.STRING)
    private RoleType type;

}
