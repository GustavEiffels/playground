package practice.jpa.board.exceptionBundle;


import org.springframework.stereotype.Component;

@Component
public class NotFoundLoginId extends RuntimeException{
    public NotFoundLoginId() {
        super();
    }

    public NotFoundLoginId(String message) {
        super(message);
    }

    public NotFoundLoginId(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundLoginId(Throwable cause) {
        super(cause);
    }

    protected NotFoundLoginId(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
