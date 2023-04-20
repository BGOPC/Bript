package src.Interpreter;

public class Tokens {
    public tokenTypes tokenType;
    public String value;
    enum tokenTypes {
        DIGITS,
        LETTER,
        LeftParenthesis,
        RightParenthesis,
        PLUS,
        MINUS,
        MULTIPLY,
        DIVIDE,
    }
    public Tokens(tokenTypes tokenType) {

    }
    public Tokens(tokenTypes tokenType, String value) {
        this.tokenType = tokenType;
        this.value = value;
    }
    public tokenTypes getTokenType(String value) throws IllegalArgumentException {
        if ("0123456789".contains(value)) {
            return tokenTypes.DIGITS;
        } else if ("abcdefghijklmnopqrstuvwxyz".contains(value.toLowerCase())) {
            return tokenTypes.LETTER;
        } else {
            switch (value) {
                case "+":
                    return tokenTypes.PLUS;
                case "-":
                    return tokenTypes.MINUS;
                case "*":
                    return tokenTypes.MULTIPLY;
                case "/":
                    return tokenTypes.DIVIDE;
                case "(":
                    return tokenTypes.LeftParenthesis;
                case ")":
                    return tokenTypes.RightParenthesis;
                default:
                    throw new IllegalArgumentException("Invalid token value");
            }
        }
    }
}
