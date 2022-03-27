# onp

Ten projekt posiada prostą implementację kalkulatora [ONP](https://pl.wikipedia.org/wiki/Odwrotna_notacja_polska).
Poprawność kalkulatora sprawdzona jest testami w JUnit.

## Użycie

### Interpretacja wyrażeń
Aby obliczyć wartość wyrażenia z tekstu źródłowego, należy użyć klasy `Parser`.
Ta klasa przeczyta zawartość Scannera do końca i zwróci wynik wyrażenia. 
Klasa nie sprawdza poprawności wyrażeń, ewentualne błędy zwróci `Calculator`.

Przykład użycia:
```java
String expression = "5 4 + 3 * 13 5 % 7 3 / * + 13 -";
Parser parser = new Parser(new Scanner(expression), new Calculator());
assertEquals(21, parser.parse());
```

Obsługiwane operatory: 
* `+` - dodawanie
* `-` - odejmowanie
* `*` - mnożenie
* `/` - dzielenie
* `%` - modulo

### Ręczne obliczenia
Implementacja kalkulatora znajduje się w klasie `Calculator`.
Kolejne liczby i operatory należy wstawiać do kalkulatora za pomocą metod `put(double)` 
oraz `calculate(Operation)`.
Obliczenia należy zakończyć wywołaniem `getResult()`.

Przykład użycia:
```java
Calculator calculator = new Calculator();
calculator.put(5);
calculator.put(2);
calculator.calculate(Operation.ADD);
assertEquals(7,calculator.getResult());
```