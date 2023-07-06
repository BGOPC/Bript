package src.utils.Errors;

public class ParseExceptions {
    public String message;
    public ParseExceptions(String title, String message){
        this.message = message;
        this.log();
    }
    public void log(){
        System.out.println("ParseError: " + this.message);
        System.exit(0);
    }
}
