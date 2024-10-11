package nl.dylaan.calculator.tokenizer;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {
    private final String formula;
    private int cursor = 0;

    public Tokenizer(String formula) {
        this.formula = formula;
    }

    public List<Token> getTokens() throws Exception {
        ArrayList<Token> tokens = new ArrayList<>();

        char subject;
        do {
            subject = formula.charAt(cursor);
            Token token = parseToken(subject);
            if(token == null) {
                throw new Exception("Unexpected token at position " + cursor);
            }
            tokens.add(token);
        } while (advance());

        return tokens;
    }

    private Token parseToken(char subject) {
        return switch (subject) {
            case '(' -> new Token(TokenType.OpenBracket, "(");
            case ')' -> new Token(TokenType.CloseBracket, ")");
            case '*' -> new Token(TokenType.Multiplication, "*");
            case '/' -> new Token(TokenType.Division, "/");
            case '+' -> new Token(TokenType.Addition, "+");
            case '-' -> new Token(TokenType.Subtraction, "-");
            default -> parseTokenNumberLiteral(subject);
        };
    }

    private Token parseTokenNumberLiteral(char subject) {
        if (!isDigit(subject)) {
            return null;
        }

        StringBuilder numberLiteralValue = new StringBuilder();
        numberLiteralValue.append(subject);
        while(isDigit(peek()) && advance()) {
            numberLiteralValue.append(formula.charAt(cursor));
        }
        return new Token(TokenType.NumberLiteral, numberLiteralValue.toString());
    }

    private boolean isDigit(char subject) {
        return subject >= '0' && subject <= '9';
    }

    private boolean advance()  {
        cursor++;
        return cursor != formula.length();
    }

    private char peek() {
        if(cursor+1 == formula.length()) {
            return '\0';
        }
        return formula.charAt(cursor+1);
    }
}
