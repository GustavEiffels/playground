package practice.jpa.board.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import practice.jpa.board.enumtype.ErrorCode;
import practice.jpa.board.exceptionBundle.token.JwtValidCheckException;

import java.io.IOException;

@Component
public class JwtExceptionHandler extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {

            filterChain.doFilter(request,response);
        }catch (JwtValidCheckException e){

            setErrorResponse(e.getErrorCode().getStatus(),response,e);
        }
    }

    public void setErrorResponse(HttpStatus status, HttpServletResponse response, JwtValidCheckException e)
    {
        response.setStatus(status.value());
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        ErrorCode errorCode = e.getErrorCode();

        try{
          String json = new ObjectMapper().writeValueAsString(ErrorCode.of(errorCode,e));
          response.getWriter().write(json);

        }catch (IOException ioException)
        {
            ioException.printStackTrace();
        }
    }
}
