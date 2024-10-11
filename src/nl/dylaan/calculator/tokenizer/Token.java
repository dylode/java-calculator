package nl.dylaan.calculator.tokenizer;

public class Token {
    private final TokenType tokenType;
    private final String value;

    protected Token(TokenType tokenType, String value) {
        this.tokenType = tokenType;
        this.value = value;
    }

    public TokenType getTokenType() {
        return tokenType;
    }

    public String getValue() {
        return value;
    }
}
