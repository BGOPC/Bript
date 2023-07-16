package src.utils.Errors;

public class TokenizingException extends BaseError {
    public TokenizingException(String message) {
        super("TokenizingException", message);
        this.log();
    }
}
