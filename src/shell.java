package src;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.stream.Stream;

import src.Tokenize.*;
import src.parse.Parser;

public class shell {
    public static Scanner prompt = new Scanner(System.in);
    public static Stream<Object> yieldNestedList(ArrayList<Object> list) {
        return list.stream().flatMap(item -> {
            if (item instanceof String) {
                return Stream.of(item);
            } else if (item instanceof ArrayList) {
                return yieldNestedList((ArrayList<Object>) item);
            } else {
                return Stream.empty();
            }
        });
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
            System.out.println(ParsedTokens);
        }
    }
}
