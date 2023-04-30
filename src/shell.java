package src;
import java.util.Scanner;
import java.util.ArrayList;

import src.Tokenize.*;
import src.Parse.Parser;
import src.Interpreter.Interpreter;
public class shell {
    public static Scanner prompt = new Scanner(System.in);

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
            Interpreter commandsInterpreter = new Interpreter(ParsedTokens);
            String Interpreted = commandsInterpreter.Interpret(); // String is not permanent
            System.out.println(ParsedTokens);

        }
    }
}
