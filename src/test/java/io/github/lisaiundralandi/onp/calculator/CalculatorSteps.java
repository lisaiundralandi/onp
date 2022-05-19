package io.github.lisaiundralandi.onp.calculator;

import io.cucumber.java.pl.Kiedy;
import io.cucumber.java.pl.Wtedy;
import io.github.lisaiundralandi.onp.Calculator;
import io.github.lisaiundralandi.onp.Operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CalculatorSteps {
    private final Calculator calculator = new Calculator();
    private Exception exception;

    @Kiedy("podam do kalkulatora wartość {double}")
    public void podam_do_kalkulatora_wartość(double number) {
        calculator.put(number);
    }
    @Kiedy("wybiorę operację dodawania")
    public void wybiorę_operację_dodawania() {
       calculator.calculate(Operation.ADD);
    }
    @Kiedy("wybiorę operację mnożenia")
    public void wybiorę_operację_mnozenia() {
        try {
            calculator.calculate(Operation.MULTIPLY);
        } catch (Exception e){
            exception = e;
        }
    }

    @Wtedy("wynikiem operacji będzie {double}")
    public void wynikiem_operacji_będzie(double number) {
        assertEquals(number, calculator.getResult());
    }

    @Wtedy("powinien zostać wyrzucony wyjątek")
    public void powinien_zostać_wyrzucony_wyjątek() {
        assertNotNull(exception);
    }
}
