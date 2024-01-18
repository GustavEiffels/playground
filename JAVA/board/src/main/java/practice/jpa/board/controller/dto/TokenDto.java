package practice.jpa.board.controller.dto;

import io.jsonwebtoken.Claims;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.Authentication;
import practice.jpa.board.enumtype.JwtState;

public interface TokenDto
{
    @Getter
    @Setter
    public class ValidCheckResult{
        public ValidCheckResult(){}

        public ValidCheckResult(Claims claims){
            this.claims = claims;
        }

        public ValidCheckResult(JwtState tokenState, Exception e)
        {
            this.tokenState = tokenState;
            this.e = e;
            this.isAvailable = false;
        }
        private Claims claims;

        private JwtState tokenState = JwtState.AVAILABLE;

        private Exception e         = null;

        private Boolean isAvailable = true;
    }

    @Getter
    @Setter
    public class GetAuthenticationResult
    {
        public GetAuthenticationResult(){}
        public GetAuthenticationResult FAIL(boolean isSuccess,ValidCheckResult validCheckResult)
        {
            this.isSuccess = false;
            this.validCheckResult = validCheckResult;
            return this;
        }

        public GetAuthenticationResult SUCCESS(Authentication authentication)
        {
            this.authentication = authentication;
            return this;
        }


        private boolean isSuccess = true;
        private Authentication authentication;
        private ValidCheckResult validCheckResult;
    }
}
