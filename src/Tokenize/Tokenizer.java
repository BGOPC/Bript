package src.Tokenize;

import java.util.ArrayList;

class StringTokenIndexPair {
    private String string;
    private int idx;
    private Token.tokenTypes tokenType;

    public StringTokenIndexPair(String string, Token.tokenTypes tokenType, int idx) {
        this.string = string;
        this.tokenType = tokenType;
        this.idx = idx;
    }

    public String getString() {
        return string;
    }

    public int getIndex() {
        return idx;
    }

    public Token.tokenTypes getTokenType() {
        return tokenType;
    }
}

public class Tokenizer {
    public String commands;
    public int charCount;

    public Tokenizer(String commands) {
        this.commands = commands;
        this.charCount = 0;
    }

    public Token.tokenTypes advance(String value) throws Exception {
        Token.tokenTypes type = Token.getTokenType(value);
        this.charCount++;
        return type;
    }

    public StringTokenIndexPair TokensToNumberToken(int idx) {
        char currentToken = this.commands.charAt(idx);
        StringBuilder Number = new StringBuilder(String.valueOf(currentToken));
        int dc = 0;
        boolean runNumber = true;
        while (runNumber) {
            if (this.commands.length() > idx + 1) {
                switch (Token.getTokenType(String.valueOf(this.commands.charAt(idx + 1)))) {
                    case INTEGER:
                        Number.append(String.valueOf(this.commands.charAt(idx + 1)));
                        break;
                    case FLOAT:
                        Number.append(String.valueOf(this.commands.charAt(idx + 1)));
                        dc++;
                        if (dc > 1) {
                            runNumber = false;
                            throw new IllegalArgumentException("Invalid Number");
                        }
                        break;
                    default:
                        runNumber = false;
                        break;
                }
                if (runNumber) idx++;
            } else break;
        }
        Token.tokenTypes type = (dc != 1) ? Token.tokenTypes.INTEGER : Token.tokenTypes.FLOAT;
        String StringNumber = Number.toString();
        return new StringTokenIndexPair(StringNumber, type, idx);
    }

    public ArrayList<Token> Tokenize() throws Exception {
        ArrayList<Token> tokens = new ArrayList<>();
        int i = 0;
        while (i < this.commands.length()) {
            char token = this.commands.charAt(i);
            if (!(String.valueOf(token).equals(" ") || String.valueOf(token).equals("\n"))) {
                String tokenString = String.valueOf(token);
                Token.tokenTypes type = this.advance(tokenString);
                if (type == Token.tokenTypes.INTEGER) {
                    StringTokenIndexPair newTokenString = TokensToNumberToken(i);
                    tokenString = newTokenString.getString();
                    type = newTokenString.getTokenType();
                    i = newTokenString.getIndex(); // Set the new index
                }
                Token currentToken = new Token(type, tokenString);
                tokens.add(currentToken);
            }
            i++;
        }
        return tokens;
    }
}
