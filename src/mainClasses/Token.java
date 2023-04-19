package src.mainClasses;

public class Token{
    public String Type;
    public Number Value = null;
    public String Out;
    public Token(String ttype, int value){ // ttype = Token Type
        this.Type = ttype;
        this.Value = value;
        this.Out = String.format("%s:%d",ttype,value);
    };
    public Token(String ttype){ // ttype = Token Type
        this.Type = ttype;
        this.Out = String.format("%s",ttype);
    };
    public Token(String ttype, float value){ // ttype = Token Type
        this.Type = ttype;
        this.Value = value;
        this.Out = String.format("%s:%f",ttype,value);
    }

    public static String INT = "Int";
    public static String FLOAT = "Float";
    public static String PLUS = "Plus";
    public static String MIN = "Minus";
    public static String DIV = "Divide";
    public static String MUL = "Multiply";
    public static String LPAREN = "Left Parenthesis";
    public static String RPAREN = "Right Parenthesis";
    public static String DIGITS = "0123456789";
    public static String LETTERS = "abcdefghijklmnopqrstuvwxyz" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
}