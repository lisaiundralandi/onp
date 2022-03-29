package io.github.lisaiundralandi.onp;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class InfixConverter<T> {
    private final OnpBuilder<T> onpBuilder;
    private final Deque<Character> operationStack = new ArrayDeque<>();

    public InfixConverter(OnpBuilder<T> onpBuilder) {
        this.onpBuilder = onpBuilder;
    }

    public T convert(Scanner scanner) {
        while (scanner.hasNext()) {
            if (scanner.hasNextDouble()) {
                onpBuilder.put(scanner.nextDouble());
            } else {
                char sign = scanner.next()
                        .charAt(0);
                handleSign(sign);
            }
        }
        removeFromStack();
        return onpBuilder.finish();
    }

    private void handleSign(char sign) {
        if (sign == '(') {
            operationStack.push(sign);
        } else if (sign == ')') {
            removeFromStack();
        } else {
            handleOperator(sign);
        }
    }

    private void removeFromStack() {
        while (!operationStack.isEmpty() && operationStack.peek() != '(') {
            char sign = operationStack.pop();
            onpBuilder.put(operationOf(sign));
        }
        if (!operationStack.isEmpty()) {
            operationStack.pop();
        }
    }

    private void handleOperator(char sign) {
        if (operationStack.isEmpty()) {
            operationStack.push(sign);
        } else if (priorityOf(sign) > priorityOf(operationStack.peek())) {
            operationStack.push(sign);
        } else if (priorityOf(sign) <= priorityOf(operationStack.peek())) {
            while (!operationStack.isEmpty() && priorityOf(sign) <= priorityOf(operationStack.peek())) {
                onpBuilder.put(operationOf(operationStack.pop()));
            }
            operationStack.push(sign);
        }
    }

    private Operation operationOf(char sign) {
        return switch (sign) {
            case '+' -> Operation.ADD;
            case '-' -> Operation.SUBTRACT;
            case '*' -> Operation.MULTIPLY;
            case '/' -> Operation.DIVIDE;
            case '%' -> Operation.REMAINDER;
            default -> throw new IllegalStateException("Unexpected value: " + sign);
        };
    }

    private int priorityOf(char sign) {
        return switch (sign) {
            case '(' -> 0;
            case '+', '-', ')' -> 1;
            case '/', '*', '%' -> 2;
            default -> throw new IllegalStateException("Unexpected value: " + sign);
        };
    }
}
