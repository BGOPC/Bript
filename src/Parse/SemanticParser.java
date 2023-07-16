package src.Parse;

import src.utils.Nodes.*;

import java.util.ArrayList;

public class SemanticParser {
    public ArrayList<Object> tokens;
    public int index;
    public BinaryOperationNode<?, ?> currentNode;
    public Object currentValue;

    public SemanticParser(ArrayList<Object> tokens){
        this.tokens = tokens;
        this.index = 0;
        this.currentValue = tokens.get(this.index);
        this.currentNode = null;
    }
}
