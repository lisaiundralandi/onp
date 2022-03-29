package io.github.lisaiundralandi.onp;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class InfixConverterTest {
    private final InfixConverter<String> infixConverter = new InfixConverter<>(new OnpStringBuilder());

    @Test
    void shouldConvertSimpleExpression() {
        String result = infixConverter.convert(new Scanner("5 + 17 - 4"));
        assertEquals("5.0 17.0 + 4.0 - ", result);
    }

    @Test
    void shouldConvertWithDifferentPriority() {
        String result = infixConverter.convert(new Scanner("2 + 5 * 4 % 4"));
        assertEquals("2.0 5.0 4.0 * 4.0 % + ", result);
    }

    @Test
    void shouldConvertWithBrackets() {
        String result = infixConverter.convert(new Scanner("( 5 + 3 ) / 2"));
        assertEquals("5.0 3.0 + 2.0 / ", result);
    }

    @Test
    void shouldThrowException() {
        Scanner scanner = new Scanner("2 ^ 2 + 3");
        assertThrows(IllegalStateException.class, () -> infixConverter.convert(scanner));
    }

}