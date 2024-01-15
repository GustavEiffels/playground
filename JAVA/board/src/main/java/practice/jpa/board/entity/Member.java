package practice.jpa.board.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Generated;
import lombok.Getter;
import practice.jpa.board.entity.embedded.Address;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@Table(uniqueConstraints = @UniqueConstraint( columnNames = {"userEmail"}))
public class Member extends BaseEntity
{
    public Member(){}
    public Member(String userName, int age, String userEmail, String phone, String city,String street, String zipcode)
    {
        this.userName = userName;
        this.phone = phone;
        this.userEmail = userEmail;
        this.age = age;
        this.address = new Address(city,street,zipcode);
    }


    @Id @Generated
    @Column(name = "member_pid")
    private Long pid;

    private String userName;

    private int age;

    private String userEmail;

    private String phone;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member")
    @Builder.Default
    private List<Auth> auths = new ArrayList<>();


}
