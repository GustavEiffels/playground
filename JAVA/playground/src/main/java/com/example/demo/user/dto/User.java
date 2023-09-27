package com.example.demo.user.dto;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import com.example.demo.common.dto.BaseEntity;
import com.example.demo.common.dto.Rank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User extends BaseEntity
{
    private String  name;
    private int     age;
    private String  id;
    private Boolean gender;

    @Enumerated(EnumType.STRING) 
    // private Rank    rank;   -> rank 라는 mysql keyword 가 존재
    private Rank    userRank;
        
}
