package practice.jpa.board.controller.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;
import practice.jpa.board.common.dto.ResponseTokenDto;

public interface LoginDto
{
    @Builder
    @Getter
    @Setter
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    class Request
    {

        private String loginId;
        private String password;
    }

    @SuperBuilder
    @Getter
    @Setter
    @ToString
    class Response extends ResponseTokenDto
    {

    }
}
