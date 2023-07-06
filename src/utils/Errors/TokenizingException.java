package src.utils.Errors;

public class TokenizingException {
    public String message;
    public TokenizingException(String title, String message){
        this.message = message;
        this.log();
    }
    public void log(){
        System.out.println("Tokenizing Error: " + this.message);
        System.exit(0);
    }
}
