package src;
import java.util.Scanner;
import java.util.ArrayList;
import src.Tokenize.*;
public class shell {
    public static Scanner prompt = new Scanner(System.in);

    public static void main(String[] args) {
        String command = "";
        while (!command.equals("EOF")) {
            System.out.print("Command !#> ");
            command = prompt.nextLine();
            if (!command.equals("EOF")) {
                Tokenizer commandTokenizer = new Tokenizer(command);
                ArrayList<Token> Tokenized = commandTokenizer.Tokenize();
                String output = "[ ";
                for (Token token : Tokenized) {
                    output += token.toString() + ", ";
                }
                System.out.println(output + "]");
            }
        }
        System.out.println("Bye");
    }
}
