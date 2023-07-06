package src.utils.Errors;

public class Error {
    public String title;
    public String message;
    public Error(String title, String message){
        this.title = title;
        this.message = message;
        this.log();
    }
    public void log(){
        System.out.println(this.title + ": " + this.message);
        System.exit(0);
    }
}
