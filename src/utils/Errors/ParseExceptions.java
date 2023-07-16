package src.utils.Errors;

public class ParseExceptions extends BaseError{
    public ParseExceptions(String message){
        super("ParseException", message);
        this.log();
    }
}
