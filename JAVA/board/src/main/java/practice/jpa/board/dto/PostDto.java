package practice.jpa.board.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;
import practice.jpa.board.common.dto.MasterResponseDto;
import practice.jpa.board.common.dto.RequestTokenDto;

public interface PostDto {

    public class CreatePost
    {
        @SuperBuilder
        @Getter
        @Setter
        public static class Request extends RequestTokenDto
        {
            private String title;
            private String content;
        }

        @Getter
        @Setter
        @ToString
        @SuperBuilder
        public static class Response extends MasterResponseDto
        {

        }

    }
}
