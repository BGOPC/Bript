package src.mainClasses;

import java.util.ArrayList;
import java.util.List;

import src.mainClasses.utilities.Nodes.*;

public class parser {
    public static ArrayList<Token> tokens;
    public static int tok_idx = -1;
    public static Token CT;
    public static Token op_tok;
    public parser(ArrayList<Token> tokens) {
        parser.tokens = tokens;
        parser.advance();
    }
    public static Token advance() {
        parser.tok_idx++;
        if (parser.tok_idx < tokens.size()) {
            parser.CT = parser.tokens.get(parser.tok_idx);
        }
        return parser.CT;
    }
    public static NumberNode factor(){
        Token tok = parser.CT;
        List<String> Nums = new ArrayList<String>();
        Nums.add(Token.INT);
        Nums.add(Token.FLOAT);
        for (String N : Nums){
            if (N.contains(tok.Type)){
                parser.advance();
                return new NumberNode(tok);
            }
        }
        return null;
    }
    public static BinOpNode term() {
        NumberNode left = parser.factor();
        List<String> ops = new ArrayList<String>();
        ops.add(Token.MUL);
        ops.add(Token.DIV);
        BinOpNode Left = null;
        while (ops.contains(CT.Type)) {
            op_tok = CT;
            NumberNode right = parser.factor();
            Left = new BinOpNode(left, op_tok, right);
        }
        return Left;
    }
    public static BinOpNode expr() {
        NumberNode left = parser.factor();
        List<String> ops = new ArrayList<String>();
        ops.add(Token.PLUS);
        ops.add(Token.MIN);
        BinOpNode Left = null;
        while (ops.contains(CT.Type)) {
            op_tok = CT;
            BinOpNode right = parser.term();
            Left = new BinOpNode(left, op_tok, right);
        }
        return Left;
    }
    public BinOpNode parse(){
        BinOpNode res = parser.expr();
        return res;
    }

}
