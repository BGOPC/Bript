package src.mainClasses.utilities.Nodes;

import java.util.ArrayList;
import src.mainClasses.Token;

public class BinOpNode {
    public static NumberNode left_node;
    public static Token op_tok;
    public static NumberNode right_node;
    public BinOpNode(NumberNode left, Token op_tok, NumberNode right) {
        BinOpNode.left_node = left;
        BinOpNode.op_tok = op_tok;
        BinOpNode.right_node = right;
    }
    public BinOpNode(NumberNode left, Token op_tok, BinOpNode right) {
        BinOpNode.left_node = left;
        BinOpNode.op_tok = op_tok;
        BinOpNode.right_node = right;
    }
}
