import nl.dylaan.calculator.Calculator;

public class Application {
    public static void main(String[] args) {
        System.out.print("Enter your formula: ");
        double answer = Calculator.fromUserInput();
        System.out.format("The answer is: %.2f", answer);
    }
}