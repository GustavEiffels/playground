package practice.jpa.board.common.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class RequestTokenDto {
    private String accessToken;
}
