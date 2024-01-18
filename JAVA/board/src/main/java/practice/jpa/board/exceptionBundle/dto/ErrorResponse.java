package practice.jpa.board.exceptionBundle.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import practice.jpa.board.enumtype.ErrorCode;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ErrorResponse {

    private String message;
    private String code;
    private HttpStatus httpStatus;
    private Throwable cause;

    public ErrorResponse(String message, String code, HttpStatus httpStatus, Exception e)
    {
        this.message = message;
        this.code = code;
        this.httpStatus = httpStatus;
        this.cause = e.getCause();
    }




    public static ErrorResponse of(ErrorCode errorCode, Exception e)
    {
        return new ErrorResponse(errorCode.getMessage(), errorCode.getCode(), errorCode.getStatus(), e);
    }




}
