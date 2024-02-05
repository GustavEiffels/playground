package practice.jpa.board.exceptionBundle.exceptions;

public class SecurityKeySettingException extends RuntimeException{
    public SecurityKeySettingException() {
        super();
    }

    public SecurityKeySettingException(String message) {
        super("Security Ket Setting Exception Emerge");
    }

    public SecurityKeySettingException(String message, Throwable cause) {
        super(message, cause);
    }

    public SecurityKeySettingException(Throwable cause) {
        super(cause);
    }

    protected SecurityKeySettingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
