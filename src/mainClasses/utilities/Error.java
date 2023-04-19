package src.mainClasses.utilities;
public class Error {
    private static String Name = null;
    private static position pos_start = null;
    private static position pos_end = null;
    private static String Det = null;
    public Error(position pos_start, position pos_end, String name,String det){
        Error.pos_start = pos_start;
        Error.pos_end = pos_end;
        Error.Det = det;
        Error.Name = name;

    }
    public String out(){
        return String.format("%s:%s\nFile %s, at Line %d, Column %d",Error.Name,Error.Det,Error.pos_start.fn,pos_start.ln + 1,pos_start.col);
    }
}
