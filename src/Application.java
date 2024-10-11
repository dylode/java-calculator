import nl.dylaan.calculator.Calculator;

public class Application {
    public static void main(String[] args) {
//        System.out.print("Enter your formula: ");
//        double answer = Calculator.fromUserInput();

        double answer = Calculator.calculate("10+5*(30+1)/4");
        System.out.format("The answer is: %.2f", answer);
    }
}