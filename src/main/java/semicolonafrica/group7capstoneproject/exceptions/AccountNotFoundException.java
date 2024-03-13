package semicolonafrica.group7capstoneproject.exceptions;

public class AccountNotFoundException extends Throwable{
    public AccountNotFoundException(String message) {
        super(message);
    }

    public AccountNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
