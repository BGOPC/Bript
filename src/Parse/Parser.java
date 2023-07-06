package src.Parse;

import src.Tokenize.Token;

import java.util.ArrayList;

public class Parser {
    public ArrayList<Token> tokens;
    public Token currentToken;
    public int idx;

    public Parser(ArrayList<Token> tokens) {
        this.tokens = tokens;
        this.idx = 0;
        this.currentToken = this.tokens.get(this.idx);
    }

    public void advance() {
        this.idx++;
        if (this.idx < this.tokens.size()) {
            this.currentToken = this.tokens.get(this.idx);
        }
    }

    public ArrayList<Object> stackBuilder() {
        ArrayList<Object> stack = new ArrayList<Object>();
        this.advance();
        while (currentToken.tokenType != Token.tokenTypes.RightParenthesis) {
            if (currentToken.tokenType == Token.tokenTypes.LeftParenthesis) {
                ArrayList<Object> miniStack = this.stackBuilder();
                stack.add(miniStack);
            }
            if (currentToken.tokenType != Token.tokenTypes.RightParenthesis) {
                stack.add(currentToken);
            }
            this.advance();
        }
        this.advance();
        return stack;
    }

    public ArrayList<Object> parse() {
        ArrayList<Object> parsedTokens = new ArrayList<Object>();
        if (!stackValidator()) {
            System.out.println("Parsing Error");
            System.exit(0); // Temporary: Customized errors will be added
        }
        do {
            if (currentToken.tokenType == Token.tokenTypes.LeftParenthesis) parsedTokens.add(stackBuilder());
            if (currentToken.tokenType != Token.tokenTypes.RightParenthesis) {
                parsedTokens.add(currentToken);
            }
            this.advance();
        } while (this.idx < this.tokens.size());
        return parsedTokens;
    }

    public boolean stackValidator() {
        int leftCount = 0;
        int rightCount = 0;
        for (Token token : this.tokens) {
            if (token.tokenType == Token.tokenTypes.LeftParenthesis) leftCount++;
            if (token.tokenType == Token.tokenTypes.RightParenthesis) rightCount++;
        }
        boolean countValidator = leftCount == rightCount;
        assert countValidator;
        for (int i = 0; i < this.tokens.size(); i++){
            if (this.tokens.get(i).tokenType == Token.tokenTypes.LeftParenthesis)
                if (this.tokens.get(i+1).tokenType == Token.tokenTypes.RightParenthesis)
                    return false;
        }
        return true;
    }
}
