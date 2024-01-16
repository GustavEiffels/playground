package practice.jpa.board.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class JoinDto
{
    private String userName;
    private int age;
    private String userEmail;
    private String userNick;
    private String phone;
    private String city;
    private String street;
    private String zipcode;
    private String loginId;
    private String password;



}
