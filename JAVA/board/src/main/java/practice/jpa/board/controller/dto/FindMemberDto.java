package practice.jpa.board.controller.dto;



import lombok.Data;

@Data
public class FindMemberDto
{
    private String userName;
    private int age;
    private String userEmail;
    private String userNick;
    private String phone;
    private String city;
    private String street;
    private String zipcode;
    private int ageGoe;
    private int ageLoe;
}
