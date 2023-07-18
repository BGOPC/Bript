package src.utils.Nodes;

public class NumberNode extends BaseNode {
    public int value;

    public NumberNode(int value) {
        this.value = value;
    }

    public NumberNode add(NumberNode RHS) {
        return new NumberNode(this.value + RHS.value);
    }

    public NumberNode subtract(NumberNode RHS) {
        return new NumberNode(this.value - RHS.value);
    }

    public NumberNode multiply(NumberNode RHS) {
        return new NumberNode(this.value * RHS.value);
    }

    public NumberNode divide(NumberNode RHS) {
        return new NumberNode(this.value / RHS.value);
    }
}
