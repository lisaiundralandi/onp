package io.github.lisaiundralandi.onp;

public class CalculatingOnpBuilder implements OnpBuilder<Double> {
    private final Calculator calculator = new Calculator();

    @Override
    public void put(double number) {
        calculator.put(number);
    }

    @Override
    public void put(Operation operation) {
        calculator.calculate(operation);
    }

    @Override
    public Double finish() {
        return calculator.getResult();
    }
}
