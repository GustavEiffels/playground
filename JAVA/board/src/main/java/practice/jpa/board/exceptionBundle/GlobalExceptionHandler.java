package practice.jpa.board.exceptionBundle;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import practice.jpa.board.enumtype.ErrorCode;
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
      ErrorResponse response = ErrorResponse.of(errorCode,e);
      log.error("handleMalformedJwtException",e);
      return new ResponseEntity<>(response, e.getErrorCode().getStatus());
    }

}
