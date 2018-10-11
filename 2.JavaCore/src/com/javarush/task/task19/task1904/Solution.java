package com.javarush.task.task19.task1904;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

/* 
И  еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
В классе адаптере создать приватное финальное поле Scanner fileScanner. Поле инициализировать в конструкторе с одним аргументом типа Scanner.

Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950
Петров Петр Петрович 31 12 1957

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные только одного человека.


Требования:
1. PersonScanner должен быть интерфейсом.
2. Класс PersonScannerAdapter должен реализовывать интерфейс PersonScanner.
3. Класс PersonScannerAdapter должен содержать приватное поле fileScanner типа Scanner.
4. Класс PersonScannerAdapter должен содержать конструктор с параметром Scanner.
5. Метод close() класса PersonScannerAdapter должен делегировать полномочие такому же методу fileScanner.
6. Метод read() класса PersonScannerAdapter должен читать строку с файла, парсить её, и возвращать данные только одного человека, в виде объекта класса Person.
*/

public class Solution {

    public static void main(String[] args) throws IOException, ParseException {
        PersonScannerAdapter personScannerAdapter = new PersonScannerAdapter(new Scanner(new FileReader("/home/ooevg/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1904/test.txt")));
        System.out.println(personScannerAdapter.read().toString());
        personScannerAdapter.close();

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner scanner) {
            this.fileScanner = scanner;
        }

        @Override
        public Person read() throws IOException, ParseException {
            Person readPerson;
            String[] parseString = this.fileScanner.nextLine().split(" ");
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd mm yyyy", Locale.ENGLISH);
            String fullData = parseString[3] + " " + parseString[4] + " " + parseString[5];
            readPerson = new Person(parseString[0], parseString[1], parseString[2], dateFormat.parse(fullData));
            return readPerson;
        }

        @Override
        public void close() throws IOException {
            this.fileScanner.close();
        }
    }
}
