package src;
import java.util.Scanner;

import src.mainClasses.DoubleReturn_par;
// import src.mainClasses.DoubleReturn_tok;
import src.mainClasses.Run;
// import src.mainClasses.Token;
// import src.mainClasses.utilities.ConvertTokens;
import src.mainClasses.utilities.Error;
import src.mainClasses.utilities.Nodes.BinOpNode;

// import java.util.ArrayList;

public class shell {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args){
        while (true) {
            System.out.print("Command !#> ");
            String cmd = input.nextLine();
            DoubleReturn_par out = Run.run("<stdin>",cmd);
            BinOpNode tokens = out.getFirstValue();
            Error error = out.getSecondValue();
            if (error != null){
                System.out.println("Got Error");
                System.out.println(error.out());
            } else {
                // System.out.println(ConvertTokens.outter(tokens));
                System.out.println(tokens);
            }
        }
    }
}
