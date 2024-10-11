package nl.dylaan.calculator;

import nl.dylaan.calculator.tokenizer.Token;
import nl.dylaan.calculator.tokenizer.Tokenizer;

import java.util.List;
import java.util.Scanner;

/**
 * The Calculator class can be used as the entrypoint
 * for the calculator. It can be compared to a factory.
 */
public class Calculator {
    /**
     * Retrieve the formula from stdin and return the answer
     * @return the answer of the formula
     */
    public static double fromUserInput() {
        Scanner scanner = new Scanner(System.in);
        String formula = scanner.nextLine();
        scanner.close();
        return Calculator.calculate(formula);
    }

    public static double calculate(String formula) {
        Tokenizer tokenizer = new Tokenizer(formula);
        List<Token> tokens;
        try {
            tokens = tokenizer.getTokens();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        for (Token token : tokens) {
            System.out.format("%s => %s\n", token.getTokenType(), token.getValue());
        }

        return 0.0d;
    }
}
