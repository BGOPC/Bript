package src.mainClasses;
import src.mainClasses.utilities.Nodes.*;
import src.mainClasses.utilities.Error;

public class DoubleReturn_par {
    public BinOpNode firstValue;
    public Error secondValue;
    public DoubleReturn_par(BinOpNode firstValue, Error secondValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }
    public BinOpNode getFirstValue() {
        return this.firstValue;
    }
    public Error getSecondValue() {
        return this.secondValue;
    }
}