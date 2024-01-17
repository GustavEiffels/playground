package practice.jpa.board.exceptionBundle;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class NotFoundUserRoleException extends UsernameNotFoundException {
    public NotFoundUserRoleException(String msg) {
        super(msg);
    }
}
