package src.Interpreter;
import src.Tokenize.*;
import java.util.ArrayList;
public class Interpreter {
    public ArrayList<Object> parsedCommands;
    public int idx;
    public Object currentObject;
    public Token currentToken;

    public Interpreter(ArrayList<Object> parsedCommands) {
        this.parsedCommands = parsedCommands;
        this.idx = -1;
        this.currentObject = null;
        this.currentToken = null;
    }

    public String Interpret() throws Exception {
        this.advance();
        double result = this.expr();
        return Double.toString(result);
    }

    private void advance() {
        this.idx++;
        if (this.idx < this.parsedCommands.size()) {
            this.currentObject = this.parsedCommands.get(this.idx);
            if (this.currentObject instanceof Token) {
                this.currentToken = (Token) this.currentObject;
            }
        }
    }

    private double factor() throws Exception {
        if (this.currentToken.getType() == Token.tokenTypes.INTEGER) {
            double value = Double.parseDouble(this.currentToken.getValue());
            this.advance();
            return value;
        } else if (this.currentToken.getType() == Token.tokenTypes.LeftParenthesis) {
            this.advance();
            double result = this.expr();
            if (this.currentToken.getType() != Token.tokenTypes.RightParenthesis) {
                throw new Exception("Invalid syntax: expected right parenthesis");
            }
            this.advance();
            return result;
        } else {
            throw new Exception("Invalid syntax: expected integer or left parenthesis");
        }
    }

    private double term() throws Exception {
        double result = this.factor();
        while (this.currentToken.getType() == Token.tokenTypes.MULTIPLY) {
            this.advance();
            result *= this.factor();
        }
        return result;
    }

    private double expr() throws Exception {
        double result = this.term();
        while (this.currentToken.getType() == Token.tokenTypes.PLUS || this.currentToken.getType() == Token.tokenTypes.MINUS) {
            if (this.currentToken.getType() == Token.tokenTypes.PLUS) {
                this.advance();
                result += this.term();
            } else if (this.currentToken.getType() == Token.tokenTypes.MINUS) {
                this.advance();
                result -= this.term();
            }
        }
        return result;
    }
}