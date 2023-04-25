package src.Tokenize;

import java.util.ArrayList;

public class Tokenizer {
    public String commands;
    public int charCount;
    public Tokenizer(String commands) {
        this.commands = commands;
        this.charCount = 0;
    }
    public Token.tokenTypes advance(String value) {
        Token.tokenTypes type = Token.getTokenType(value);
        this.charCount++;
        return type;
    }
    public ArrayList<Token> Tokenize(){
        ArrayList<Token> tokens = new ArrayList<Token>();
        for (char token : this.commands.toCharArray()) {
            if (!(String.valueOf(token).equals(" ") || String.valueOf(token).equals("\n"))) {
                String tokenString = String.valueOf(token);
                Token.tokenTypes type = this.advance(tokenString);
                Token currentToken = new Token(type, tokenString);
                tokens.add(currentToken);
            }
        }
        return tokens;
    }
}
