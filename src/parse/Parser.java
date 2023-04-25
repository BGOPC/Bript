package src.parse;

import src.Tokenize.Token;

import java.util.ArrayList;

public class Parser {
    public ArrayList<Token> tokens;
    public Token currentToken;
    public int idx;

    public Parser(ArrayList<Token> tokens) {
        this.tokens = tokens;
        this.idx = 0;
        this.currentToken =  tokens.get(this.idx);
    }
    public ArrayList<Token> getTokens() {
        return new ArrayList<Token>();
    }

}
