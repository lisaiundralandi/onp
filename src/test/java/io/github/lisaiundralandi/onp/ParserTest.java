package io.github.lisaiundralandi.onp;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @Test
    void shouldParseString(){
        String expression = "5 4 + 3 * 13 5 % 7 3 / * + 13 -";
        Parser parser = new Parser(new Scanner(expression), new Calculator());
        assertEquals(21, parser.parse());
    }
}