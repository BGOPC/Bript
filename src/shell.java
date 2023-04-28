package src;
import java.util.Scanner;
import java.util.ArrayList;
import src.Tokenize.*;
import src.parse.Parser;

public class shell {
    public static Scanner prompt = new Scanner(System.in);
    public static void printNestedList(ArrayList<Object> list) {
        for (Object item : list) {
            if (item instanceof String) {
                System.out.println(item);
            } else if (item instanceof ArrayList) {
                ArrayList<Object> ItemObject = (ArrayList<Object>) item;
                printNestedList(ItemObject);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        String command;
        while (true) {
            System.out.print("Command !#> ");
            command = prompt.nextLine();
            if (command.equals("EOF")) break;
            Tokenizer commandTokenizer = new Tokenizer(command);
            ArrayList<Token> Tokenized = commandTokenizer.Tokenize();
            Parser TokenizedParser = new Parser(Tokenized);
            ArrayList<Object> ParsedTokens = TokenizedParser.ParseTokens();

        }
    }
}
