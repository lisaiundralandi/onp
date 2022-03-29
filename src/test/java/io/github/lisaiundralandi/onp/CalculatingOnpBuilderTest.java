package io.github.lisaiundralandi.onp;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class CalculatingOnpBuilderTest {
    private final InfixConverter<Double> infixConverter = new InfixConverter<>(new CalculatingOnpBuilder());

    @Test
    void shouldCalculateExpression(){
        var result = infixConverter.convert(new Scanner("3 * ( 5 + 3 ) / 2"));
        assertEquals(12.0, result);
    }
}