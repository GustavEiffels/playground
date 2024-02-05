package practice.jpa.board.controller.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;
import practice.jpa.board.common.dto.MasterResponseDto;
import practice.jpa.board.common.dto.RequestTokenDto;

public interface PostDto {

    public class CreatePost {
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

    public class SearchPost{

        @Getter
        @Setter
        @ToString
        public static class Request{
            private String authorNick   ;
            private String title        ;
            private String contents     ;
        }

        @SuperBuilder
        @Getter
        @Setter
        @Builder
        public static class Response extends MasterResponseDto{

            private String authorNick   ;
            private String title        ;
            private String contents     ;
            private Integer views       ;
        }
    }
}
