package practice.jpa.board.controller.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SearchPostResultDto {
    private String authorNick   ;
    private String title        ;
    private String contents     ;
    private Integer views       ;
}
