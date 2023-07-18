package src.utils.Nodes;

import src.utils.Errors.BaseError;

public class BaseNode {
    public BaseNode evaluate() throws BaseError {
        return new NumberNode(1);
    }
}
