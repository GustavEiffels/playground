package practice.jpa.board.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
@Builder
public class Role extends BaseEntity
{
    @Id
    @GeneratedValue
    @Column(name = "role_pid")
    private Long pid;


}
