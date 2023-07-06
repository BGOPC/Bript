package src.utils.Nodes;

import src.Tokenize.Token;

public class BinaryOperationNode<T,U> {
    public T LHS;
    public U RHS;
    public Token operator;
    public BinaryOperationNode(T LHS, U RHS, Token operator){
        this.operator = operator;
        this.LHS = LHS;
        this.RHS = RHS;
    }

}
