package practice.jpa.board.controller.dto;


import lombok.Data;

@Data
public class SearchPostDto {
    private String authorNick   ;
    private String title        ;
    private String contents     ;
    private boolean isAsc       ;
}
