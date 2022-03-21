package io.github.lisaiundralandi.onp;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void shouldCalculate(){
        Calculator calculator = new Calculator();
        calculator.put(5);
        calculator.put(2);
        calculator.calculate(Operation.ADD);
        assertEquals(7,calculator.getResult());
    }

    @Test
    void shouldBeError(){
        Calculator calculator = new Calculator();
        calculator.put(5);
        assertThrows(NoSuchElementException.class, () -> {
            calculator.calculate(Operation.MULTIPLY);
        });
    }

}