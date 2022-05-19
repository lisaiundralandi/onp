package io.github.lisaiundralandi.onp;

import io.cucumber.java.pl.Kiedy;
import io.cucumber.java.pl.Wtedy;
import io.cucumber.java.pl.Zakładającże;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class ConverterSteps {
    private InfixConverter<String> infixConverter;
    private String result;
    private Exception exception;

    @Zakładającże("wyrażenie będzie konwertowane do Stringa")
    public void wyrażenie_będzie_konwertowane_do_stringa() {
        infixConverter = new InfixConverter<>(new OnpStringBuilder());
    }

    @Kiedy("przekonwertuję wyrażenie {string}")
    public void przekonwertuję_wyrażenie(String expression) {
        try {
            result = infixConverter.convert(new Scanner(expression));
        } catch (Exception e) {
            exception = e;
        }
    }

    @Wtedy("wynikiem będzie {string}")
    public void wynikiem_będzie(String expression) {
        assertEquals(expression, result);
    }

    @Wtedy("powinien zostać wyrzucony wyjątek z informacją {string}")
    public void powinien_zostać_wyrzucony_wyjątek(String message) {
        assertNotNull(exception);
        assertEquals(message, exception.getMessage());
    }
}
