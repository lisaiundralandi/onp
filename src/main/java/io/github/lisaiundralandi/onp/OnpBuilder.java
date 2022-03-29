package io.github.lisaiundralandi.onp;

public interface OnpBuilder<T> {
    void put(double number);

    void put(Operation operation);

    T finish();
}
