package io.github.lisaiundralandi.onp;

import java.util.Scanner;

public class Parser {
    private final Scanner scanner;
    private final Calculator calculator;

    public Parser(Scanner scanner, Calculator calculator) {
        this.scanner = scanner;
        this.calculator = calculator;
    }

    public double parse() {
        while (scanner.hasNext()) {
            if (scanner.hasNextDouble()) {
                calculator.put(scanner.nextDouble());
            } else {
                String next = scanner.next();
                parseOperation(next);
            }
        }
        return calculator.getResult();
    }

    private void parseOperation(String string) {
        switch (string) {
            case "+" -> calculator.calculate(Operation.ADD);
            case "-" -> calculator.calculate(Operation.SUBTRACT);
            case "*" -> calculator.calculate(Operation.MULTIPLY);
            case "/" -> calculator.calculate(Operation.DIVIDE);
            case "%" -> calculator.calculate(Operation.REMAINDER);
        }
    }
}
