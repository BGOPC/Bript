package src;
import java.util.Scanner;
import java.util.ArrayList;
import src.Interpreter.*;
public class shell {
    public static Scanner prompt = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Command !#> ");
        String command = prompt.nextLine();
        Tokenizer commandTokenizer = new Tokenizer(command);
        ArrayList<Token> Tokenized = commandTokenizer.Tokenize();
        String output = "[ ";
        for (Token token : Tokenized) {
            output += token.toString() + ", ";
        }
        System.out.println(output+"]");
    }
}
