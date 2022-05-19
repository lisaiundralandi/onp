package io.github.lisaiundralandi.onp.converter;

import io.cucumber.java.pl.I;
import io.cucumber.java.pl.Kiedy;
import io.cucumber.java.pl.Wtedy;
import io.cucumber.java.pl.Zakładającże;
import io.github.lisaiundralandi.onp.CalculatingOnpBuilder;
import io.github.lisaiundralandi.onp.InfixConverter;
import io.github.lisaiundralandi.onp.OnpStringBuilder;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class ConverterSteps {
    private InfixConverter<?> infixConverter;
    private String result;
    private Exception exception;

    @Zakładającże("wyrażenie będzie konwertowane do Stringa")
    public void wyrażenie_będzie_konwertowane_do_stringa() {
        infixConverter = new InfixConverter<>(new OnpStringBuilder());
    }

    @Kiedy("przekonwertuję wyrażenie {string}")
    public void przekonwertuję_wyrażenie(String expression) {
        try {
            Object result = infixConverter.convert(new Scanner(expression));
            if (result != null) {
                this.result = result.toString();
            }
        } catch (Exception e) {
            exception = e;
        }
    }

    @Wtedy("wynikiem konwersji będzie {string}")
    public void wynikiem_będzie(String expression) {
        assertEquals(expression, result);
    }

    @Wtedy("powinien zostać wyrzucony wyjątek z informacją {string}")
    public void powinien_zostać_wyrzucony_wyjątek(String message) {
        assertNotNull(exception);
        assertEquals(message, exception.getMessage());
    }

    @Zakładającże("wyrażenie będzie obliczane w trakcie konwersji")
    public void wyrażenie_będzie_obliczane_w_trakcie_konwersji() {
        infixConverter = new InfixConverter<>(new CalculatingOnpBuilder());
    }
}
