package src.Tokenize;

public class Token {
    public tokenTypes tokenType;
    public String value;

    public enum tokenTypes {
        SPACE,
        INTEGER,
        FLOAT,
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

    public static tokenTypes getNumberType(String Number) {
        int DotCount = 0;
        for (int i = 0; i < Number.length(); i++) {
            if (Number.charAt(i) == '.') {
                DotCount++;
            }
        }
        if (DotCount == 1) {
            return tokenTypes.FLOAT;
        }
        return tokenTypes.INTEGER;
    }
    public tokenTypes getType() {
        return this.tokenType;
    }
    public String getValue() {
        return this.value;
    }

    public static tokenTypes getTokenType(String value) {
        if ("0123456789.".contains(value)) {
            return getNumberType(value);
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

    public String toString() {
        return this.tokenType.toString() + ":" + this.value;
    }
}
