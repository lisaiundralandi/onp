#language: pl
Funkcja: Kalkulator ONP

  Scenariusz: Dodawanie
    Kiedy podam do kalkulatora wartość 5
    I podam do kalkulatora wartość 2
    I wybiorę operację dodawania
    Wtedy wynikiem operacji będzie 7

  Scenariusz: Dodawanie i mnożenie
    Kiedy podam do kalkulatora wartość 5,2
    I podam do kalkulatora wartość 2,5
    I wybiorę operację dodawania
    I podam do kalkulatora wartość 4
    I wybiorę operację mnożenia
    Wtedy wynikiem operacji będzie 30,8

  Scenariusz: Niepoprawne dane wejściowe
    Kiedy podam do kalkulatora wartość 5
    I wybiorę operację mnożenia
    Wtedy powinien zostać wyrzucony wyjątek