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

        char current;
        while (!isAtEOF()) {
            current = formula.charAt(cursor);
            Token token = parseToken(current);
            if(token == null) {
                advance();
                continue;
                //throw new Exception("Unexpected token at " + current);
            }
            tokens.add(token);
            advance();
        }

        return tokens;
    }

    private Token parseToken(char current) {
        return switch (current) {
            case '+' -> new Token(TokenType.Addition, "+");
            case '-' -> new Token(TokenType.Subtraction, "-");
            case '*' -> new Token(TokenType.Multiplication, "*");
            case '/' -> new Token(TokenType.Division, "/");
            default -> null;
        };
    }

    private boolean isAtEOF() {
        return cursor == formula.length();
    }

    private void advance() throws Exception {
        cursor++;

        if (cursor > formula.length()) {
            throw new Exception("Unexpected EOF");
        }
    }
}
