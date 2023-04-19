package src.mainClasses.utilities;

import java.util.ArrayList;

import src.mainClasses.Token;

public class ConvertTokens {
    public static ArrayList<String> outter(ArrayList<Token> tokens){
        ArrayList<String> re = new ArrayList<String>();
        for(Token token : tokens){
            String i = "";
            if (token.Value != null){
                if (token.Value.floatValue() != token.Value.intValue()){
                    i = String.format("%s:%f",token.Type,token.Value.floatValue());
                } else {
                    i = String.format("%s:%d",token.Type,token.Value.intValue());
                }
            } else {
                i = String.format("%s",token.Type);
            }
            re.add(i);
        }
        return re;
    }
}