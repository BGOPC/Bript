package src.Parse;

import src.Tokenize.Token;

import java.util.ArrayList;

public class AbstractionSyntaxTree {
    public ArrayList<Object> tokens;
    public int idx;
    public Object currentToken;

    public AbstractionSyntaxTree(ArrayList<Object> tokens) {
        this.tokens = tokens;
    }
}
