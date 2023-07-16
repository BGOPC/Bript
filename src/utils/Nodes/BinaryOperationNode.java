package src.utils.Nodes;

import src.Tokenize.Token;

public class BinaryOperationNode<T, U> {
    public T LHS;
    public U RHS;
    public Token operator;

    public BinaryOperationNode(T LHS, U RHS, Token operator) {
        this.operator = operator;
        this.LHS = LHS;
        this.RHS = RHS;
    }

    public NumberNode evaluate() {
        if (this.LHS instanceof NumberNode && this.RHS instanceof NumberNode) {
            return calculate((NumberNode) this.LHS, (NumberNode) this.RHS, this.operator);
        } else if (this.LHS instanceof NumberNode && this.RHS instanceof BinaryOperationNode) {
            this.RHS = this.RHS.evaluate();
            return calculate((NumberNode) this.LHS, (NumberNode) this.RHS, this.operator);
        } else if (this.LHS instanceof BinaryOperationNode && this.RHS instanceof NumberNode) {
            this.LHS = this.LHS.evaluate();
            return calculate((NumberNode) this.LHS, (NumberNode) this.RHS, this.operator);
        } else if (this.RHS instanceof BinaryOperationNode && this.LHS instanceof BinaryOperationNode) {
            this.RHS = this.RHS.evaluate();
            this.LHS = this.LHS.evaluate();
            return calculate((NumberNode) this.LHS, (NumberNode) this.RHS, this.operator);
        } else return null;
    }

    public NumberNode calculate(NumberNode LHS, NumberNode RHS, Token operator) {
        return switch (operator.tokenType) {
            case PLUS -> LHS.add(RHS);
            case MINUS -> LHS.subtract(RHS);
            case MULTIPLY -> LHS.multiply(RHS);
            case DIVIDE -> LHS.divide(RHS);
            default -> null;
        };
    }
}
