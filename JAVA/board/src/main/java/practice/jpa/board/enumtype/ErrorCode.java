package practice.jpa.board.enumtype;


import lombok.Getter;
import org.springframework.http.HttpStatus;
import practice.jpa.board.exceptionBundle.dto.ErrorResponse;

@Getter
public enum ErrorCode
{
    // TOKEN
    TOKEN_INVALID(HttpStatus.BAD_REQUEST,"사용 불가능한 토큰이다.","TOKEN_ERROR_01"),
    TOKEN_EXPIRE(HttpStatus.UNAUTHORIZED,"만료된 토큰이다","TOKEN_ERROR_02"),
    TOKEN_UNSUPPORTED(HttpStatus.BAD_REQUEST,"지원되지 않는 토큰이다.","TOKEN_ERROR_03"),
    TOKEN_EMPTY(HttpStatus.BAD_REQUEST,"잘못된 토큰","TOKEN_ERROR_04"),
    TOKEN_EMPTY_AUTH(HttpStatus.UNAUTHORIZED,"권한 정보가 없는 토큰","TOKEN_ERROR_05");



    private final  HttpStatus status;
    private final  String message;
    private final  String code;

    ErrorCode(final HttpStatus status, final String message, final String code)
    {
        this.code = code;
        this.message = message;
        this.status = status;
    }

    public static ErrorResponse of(ErrorCode errorCode, Exception e)
    {
        return new ErrorResponse(errorCode.getMessage(), errorCode.getCode(), errorCode.getStatus(), e);
    }




}
