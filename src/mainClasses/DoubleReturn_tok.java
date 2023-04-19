package src.mainClasses;

import java.util.ArrayList;
import java.util.List;

import src.mainClasses.utilities.Error;

public class DoubleReturn_tok {
    public List<Token> firstValue;
    public Error secondValue;
    public DoubleReturn_tok (List<Token> firstValue, Error secondValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }
    public List<Token> getFirstValueList() {
        return this.firstValue;
    }
    public ArrayList<Token> getFirstValue() {
        return new ArrayList<Token>(this.firstValue);
    }
    public Error getSecondValue() {
        return this.secondValue;
    }
}