package practice.jpa.board.exceptionBundle.token;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import practice.jpa.board.enumtype.ErrorCode;
import practice.jpa.board.enumtype.JwtState;

@Getter
@Setter
@RequiredArgsConstructor
public class JwtValidCheckException extends RuntimeException
{
    private final ErrorCode errorCode;

    public JwtValidCheckException(JwtState state, Exception e){
        this.errorCode = ErrorCode.valueOf("TOKEN_"+state.name());
    }

    public JwtValidCheckException(JwtState state){
        this.errorCode = ErrorCode.valueOf("TOKEN_"+state.name());
    }
}
