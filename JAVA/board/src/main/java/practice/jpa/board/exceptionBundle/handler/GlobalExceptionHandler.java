package practice.jpa.board.exceptionBundle.handler;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import practice.jpa.board.exceptionBundle.enumtype.ErrorCode;
import practice.jpa.board.exceptionBundle.dto.ErrorResponse;
import practice.jpa.board.exceptionBundle.token.JwtValidCheckException;


@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler
{

    @ExceptionHandler(JwtValidCheckException.class)
    protected ResponseEntity<ErrorResponse> handleJwtValidCheckException(JwtValidCheckException e)
    {
      ErrorCode errorCode = e.getErrorCode();
      log.error("handleMalformedJwtException",e);
      return new ResponseEntity<>(ErrorCode.of(errorCode,e), errorCode.getStatus());
    }

}
