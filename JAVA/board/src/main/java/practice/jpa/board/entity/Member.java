package practice.jpa.board.entity;

import jakarta.persistence.*;
import lombok.*;
import practice.jpa.board.entity.embedded.Address;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(uniqueConstraints = @UniqueConstraint( columnNames = {"userEmail","userNick"}))
public class Member extends BaseEntity
{

    @Id @GeneratedValue
    @Column(name = "member_pid")
    private Long pid;

    private String userName;

    private int age;

    private String userEmail;

    private String phone;

    private String userNick;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member")
    @Builder.Default
    private List<Auth> auths = new ArrayList<>();

}
