package io.github.lisaiundralandi.onp;

public class OnpStringBuilder implements OnpBuilder<String> {
    private final StringBuilder stringBuilder = new StringBuilder();

    @Override
    public void put(double number) {
        stringBuilder.append(number);
        stringBuilder.append(" ");
    }

    @Override
    public void put(Operation operation) {
        switch (operation) {
            case ADD -> stringBuilder.append('+');
            case SUBTRACT -> stringBuilder.append('-');
            case MULTIPLY -> stringBuilder.append('*');
            case DIVIDE -> stringBuilder.append('/');
            case REMAINDER -> stringBuilder.append('%');
        }
        stringBuilder.append(" ");
    }

    @Override
    public String finish() {
        return stringBuilder.toString();
    }
}
