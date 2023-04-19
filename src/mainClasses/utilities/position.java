package src.mainClasses.utilities;

public class position {
    public static int idx;
    public static int ln;
    public static int col;
    public static String fn;
    public static String ftxt;
    public static position self;
    public position(int idx, int ln, int col, String fn, String ftxt){
        position.idx = idx;
        position.ln = ln;
        position.col = col;
        position.fn = fn;
        position.ftxt = ftxt;
        self = this;
    }
    public static position advance(String CC){
        idx++;
        col++;
        if (CC != null) {
            if (CC.contains("\n")) {
                ln++;
                col = 0;
            }
        }
        return self;
    }
    public static position copy(){
        return new position( idx, ln, col,fn, ftxt);
    }
}