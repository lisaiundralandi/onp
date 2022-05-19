# language: pl
Funkcja: Konwertowanie notacji

  Scenariusz: Konwersja prostego wyrażenia
    Zakładając, że wyrażenie będzie konwertowane do Stringa
    Kiedy przekonwertuję wyrażenie "5 + 17 - 4"
    Wtedy wynikiem będzie "5.0 17.0 + 4.0 - "

  Scenariusz: Konwersja wyrażenia z operatorami o różnych priorytetach
    Zakładając, że wyrażenie będzie konwertowane do Stringa
    Kiedy przekonwertuję wyrażenie "2 + 5 * 4 % 4"
    Wtedy wynikiem będzie "2.0 5.0 4.0 * 4.0 % + "

  Scenariusz: Konwersja wyrażenia zawierającego nawiasy
    Zakładając, że wyrażenie będzie konwertowane do Stringa
    Kiedy przekonwertuję wyrażenie "( 5 + 3 ) / 2"
    Wtedy wynikiem będzie "5.0 3.0 + 2.0 / "

  Scenariusz: Konwersja wyrażenia z nieznanymi operatorami
    Zakładając, że wyrażenie będzie konwertowane do Stringa
    Kiedy przekonwertuję wyrażenie "2 ^ 2 + 3"
    Wtedy powinien zostać wyrzucony wyjątek z informacją "Unexpected value: ^"