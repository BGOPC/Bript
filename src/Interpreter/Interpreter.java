package src.Interpreter;
import src.Tokenize.*;
import java.util.ArrayList;
public class Interpreter {
    public ArrayList<Object> parsedCommands;
    public int idx;
    public Object currentObject;
    public Token currentToken;
    public Interpreter(ArrayList<Object> parsedCommands){
        this.parsedCommands = parsedCommands;
        this.idx = -1;
        this.currentObject = null;
        this.currentToken = null;
    }
    public String Interpret(){
        return "1";
    }
}
