package src.utils.Nodes;

import src.Tokenize.Token;
import src.utils.Errors.BaseError;

public class BinaryOperationNode<T extends BaseNode, U extends BaseNode> extends BaseNode {
    public T lhs;
    public U rhs;
    public Token operator;

    public BinaryOperationNode(T lhs, U rhs, Token operator) {
        this.operator = operator;
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override
    public BaseNode evaluate() throws BaseError {
        if (this.lhs instanceof NumberNode && this.rhs instanceof NumberNode) {
            return calculate((NumberNode) this.lhs, (NumberNode) this.rhs, this.operator);
        } else if (this.lhs instanceof NumberNode && this.rhs instanceof BinaryOperationNode) {
            BaseNode rhsNode = this.rhs.evaluate();
            return calculate((NumberNode) this.lhs, (NumberNode) rhsNode, this.operator);
        } else if (this.lhs instanceof BinaryOperationNode && this.rhs instanceof NumberNode) {
            BaseNode lhsNode = this.lhs.evaluate();
            return calculate((NumberNode) lhsNode, (NumberNode) this.rhs, this.operator);
        } else if (this.rhs instanceof BinaryOperationNode && this.lhs instanceof BinaryOperationNode) {
            BaseNode rhsNode = this.rhs.evaluate();
            BaseNode lhsNode = this.lhs.evaluate();
            return calculate((NumberNode) lhsNode, (NumberNode) rhsNode, this.operator);
        } else throw new BaseError("Unknown Type", "");
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
