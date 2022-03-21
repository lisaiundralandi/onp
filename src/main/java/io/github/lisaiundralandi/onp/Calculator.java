package io.github.lisaiundralandi.onp;

import java.util.ArrayDeque;
import java.util.Deque;

public class Calculator {
    private final Deque<Double> stack = new ArrayDeque<>();

    public void put(double number) {
        stack.push(number);
    }

    public double getResult() {
        return stack.pop();
    }

    public void calculate(Operation operation) {
        double b = stack.pop();
        double a = stack.pop();

        switch (operation) {
            case ADD -> {
                stack.push(a + b);
            }
            case SUBTRACT -> {
                stack.push(a - b);
            }
            case MULTIPLY -> {
                stack.push(a * b);
            }
            case DIVIDE -> {
                stack.push(a / b);
            }
            case REMAINDER -> {
                stack.push(a % b);
            }
        }
    }
}
