package src;
import java.util.Scanner;
import java.util.ArrayList;
import src.Tokenize.*;
public class shell {
    public static Scanner prompt = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        String command = "";
        while (!command.equals("EOF")) {
            System.out.print("Command !#> ");
            command = prompt.nextLine();
            if (!command.equals("EOF")) {
                Tokenizer commandTokenizer = new Tokenizer(command);
                ArrayList<Token> Tokenized = commandTokenizer.Tokenize();
                StringBuilder output = new StringBuilder("[ ");
                for (Token token : Tokenized) {
                    output.append(token.toString()).append(", ");
                }
                System.out.println(output + "]");
            }
        }
        System.out.println("Bye");
    }
}
