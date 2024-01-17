package practice.jpa.board.common.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class ResponseTokenDto extends MasterResponseDto{

    private String accessToken;
    private String refreshToken;
}
