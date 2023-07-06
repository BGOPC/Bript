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
            ArrayList<Token> TokenizedTokens = commandTokenizer.Tokenize();
            Parser parser = new Parser(TokenizedTokens);
            ArrayList<Object> parsedTokens = parser.parse();
            String output = printArrayList(parsedTokens);
            System.out.println(output);

        }
    }

    public static String printArrayList(ArrayList<Object> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < list.size(); i++) {
            Object element = list.get(i);

            if (element instanceof Token) {
                sb.append("\"").append(element.toString()).append("\"");
            } else if (element instanceof ArrayList) {
                ArrayList<Object> nestedList = (ArrayList<Object>) element;
                sb.append(printArrayList(nestedList));
            }

            if (i < list.size() - 1) {
                sb.append(", ");
            }
        }

        sb.append("]");
        return sb.toString();
    }
}
