package src.Interpreter;

public class Token {
    public tokenTypes tokenType;
    public String value;
    enum tokenTypes {
        SPACE,
        DIGITS,
        LETTER,
        LeftParenthesis,
        RightParenthesis,
        PLUS,
        MINUS,
        MULTIPLY,
        DIVIDE,
    }
    public Token(tokenTypes tokenType) {
        this.tokenType = tokenType;
    }
    public Token(tokenTypes tokenType, String value) {
        this.tokenType = tokenType;
        this.value = value;
    }
    public static tokenTypes getTokenType(String value) throws IllegalArgumentException {
        if ("0123456789".contains(value)) {
            return tokenTypes.DIGITS;
        } else if ("abcdefghijklmnopqrstuvwxyz".contains(value.toLowerCase())) {
            return tokenTypes.LETTER;
        } else {
            return switch (value) {
                case " " -> tokenTypes.SPACE;
                case "+" -> tokenTypes.PLUS;
                case "-" -> tokenTypes.MINUS;
                case "*" -> tokenTypes.MULTIPLY;
                case "/" -> tokenTypes.DIVIDE;
                case "(" -> tokenTypes.LeftParenthesis;
                case ")" -> tokenTypes.RightParenthesis;
                default -> throw new IllegalArgumentException("Invalid token value");
            };
        }
    }
}
