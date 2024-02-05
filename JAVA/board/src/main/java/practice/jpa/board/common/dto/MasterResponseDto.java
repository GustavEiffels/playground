package practice.jpa.board.common.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class MasterResponseDto {
    @Builder.Default
    private boolean isSuccess = true;
    private String  code;
    private String  message;
}
