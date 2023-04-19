package src.mainClasses;

import java.util.ArrayList;
import src.mainClasses.utilities.Error;
import src.mainClasses.utilities.Nodes.*;
public class Run {
    public static DoubleReturn_par run(String fn,String cmd) {
        DoubleReturn_tok lexer = new Lexer(fn,cmd).make_tokens();
        ArrayList<Token> tokens = lexer.getFirstValue();
        Error error = lexer.getSecondValue();
        if (error == null) {
            return new DoubleReturn_par(null, error);
        } else {
            parser parser = new parser(tokens);
            BinOpNode ast = parser.parse();
            return new DoubleReturn_par(ast, null);
        }

    }
}
