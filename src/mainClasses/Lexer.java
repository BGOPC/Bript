package src.mainClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import src.mainClasses.utilities.position;
import src.mainClasses.utilities.Errors.IllegalCharError;

public class Lexer{
    public String CC;
    public String Text;
    public String fn;
    position pos;
    public Lexer(String fn, String text) {
        this.Text = text;
        this.pos = new position(-1,0,-1, fn, text);
        this.fn = fn;
    }
    public void advance(){
        position.advance(this.CC);
        CC = (position.idx < Text.length()) ? Character.toString(Text.charAt(position.idx)):null;
        // System.out.println(CC);
        // System.out.println(pos);
    }
    public DoubleReturn_tok make_tokens(){
        List<Token> tokens = new ArrayList<>();
        advance();
        while (position.idx < Text.length()){
            if ((" \t").contains(CC)){
                advance();
            }
            if ((CC).contains(" ")) {
                advance();}
            else if (Token.DIGITS.contains(CC)){
                tokens.add(MNum());
            }
            else if (CC.contains("+")){
                tokens.add(new Token(Token.PLUS));
                advance();}
            else if (CC.contains("-")){
                tokens.add(new Token(Token.MIN));
                advance();}
            else if (CC.contains("*")){
                tokens.add(new Token(Token.MUL));
                advance();}
            else if (CC.contains("/")){
                tokens.add(new Token(Token.DIV));
                advance();}
            else if (CC.contains("(")){
                tokens.add(new Token(Token.LPAREN));
                advance();}
            else if (CC.contains(")")){
                tokens.add(new Token(Token.RPAREN));
                advance();}
            else{
                position pos_start = position.copy();
                String ch = CC;
                advance();
                return new DoubleReturn_tok(tokens, new IllegalCharError(pos_start,this.pos,"'" + ch + "'"));
            };
        }
        return new DoubleReturn_tok(tokens, null);
    }
    public Token MNum(){
        StringBuilder num_str = new StringBuilder();
        int dots = 0;
        String all = Token.DIGITS + ".";
        while ( (all.contains(CC)) && (position.idx < Text.length() - 1 ) ){
            if (CC.contains(".")){
                if (dots == 1) {break;}
                dots += 1;
                num_str.append(".");
            }
            else{
                num_str.append(CC);
            }
            advance();
        }
        if (all.contains("" + CC)) {
            if (Objects.equals(CC, ".")) {
                if (dots != 1) {
                    dots++;
                    num_str.append(".");
                }
            } else {
                num_str.append(CC);
            }
            advance();
        }
        if (dots == 0){
            return new Token(Token.INT,Integer.parseInt(num_str.toString()));
        }else{
            // System.out.println( Float.parseFloat(num_str.toString()));
            return new Token(Token.FLOAT, Float.parseFloat(num_str.toString()));
        }

    }
}

