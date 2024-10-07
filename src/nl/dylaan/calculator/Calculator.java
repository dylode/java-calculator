package nl.dylaan.calculator;

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
        return 0.0d;
    }
}
