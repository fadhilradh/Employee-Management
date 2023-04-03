package fadhilradh.springadvanced.exception;

public class ApiReqException extends RuntimeException{
    public ApiReqException(String message) {
        super(message);
    }

    public ApiReqException(String message, Throwable cause) {
        super(message, cause);
    }
}
