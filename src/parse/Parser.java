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
    public ArrayList<Object> ParseTokens() throws Exception {
        ArrayList<Object> result = new ArrayList<Object>();

        while (this.idx < this.tokens.size()) {
            Token token = this.currentToken;

            if (token.tokenType == Token.tokenTypes.INTEGER) {
                result.add(token);
                this.idx++;
            } else if (token.tokenType == Token.tokenTypes.PLUS || token.tokenType == Token.tokenTypes.MINUS || token.tokenType == Token.tokenTypes.MULTIPLY) {
                result.add(token);
                this.idx++;
            } else if (token.tokenType == Token.tokenTypes.LeftParenthesis) {
                this.idx++;
                try {
                    this.currentToken = this.tokens.get(this.idx);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Index out of bounds: " + e.getMessage());
                }

                ArrayList<Object> nestedResult = new ArrayList<Object>();
                while (this.currentToken.tokenType != Token.tokenTypes.RightParenthesis) {
                    nestedResult.add(this.ParseTokens());
                    this.currentToken = this.tokens.get(this.idx);
                }

                result.add(nestedResult);
                this.idx++;
            } else if (token.tokenType == Token.tokenTypes.RightParenthesis) {
                break;
            } else {
                throw new Exception("Invalid token");
            }

            if (this.idx < this.tokens.size()) {
                this.currentToken = this.tokens.get(this.idx);
            }
        }

        return result;
    }

}
