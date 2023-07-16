package src.utils.Nodes;

import src.Tokenize.Token;

public class BinaryOperationNode<T, U> {
    public T lhs;
    public U rhs;
    public Token operator;

    public BinaryOperationNode(T lhs, U rhs, Token operator) {
        this.operator = operator;
        this.lhs = lhs;
        this.rhs = rhs;
    }

    public NumberNode evaluate() {
        if (this.lhs instanceof NumberNode && this.rhs instanceof NumberNode) {
            return calculate((NumberNode) this.lhs, (NumberNode) this.rhs, this.operator);
        } else if (this.lhs instanceof NumberNode && this.rhs instanceof BinaryOperationNode) {
            this.rhs = this.rhs.evaluate();
            return calculate((NumberNode) this.lhs, (NumberNode) this.rhs, this.operator);
        } else if (this.lhs instanceof BinaryOperationNode && this.rhs instanceof NumberNode) {
            this.lhs = this.lhs.evaluate();
            return calculate((NumberNode) this.lhs, (NumberNode) this.rhs, this.operator);
        } else if (this.rhs instanceof BinaryOperationNode && this.lhs instanceof BinaryOperationNode) {
            this.rhs = this.rhs.evaluate();
            this.lhs = this.lhs.evaluate();
            return calculate((NumberNode) this.lhs, (NumberNode) this.rhs, this.operator);
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
