package com.javarush.task.task16.task1632;
/*Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. Нить 1 должна бесконечно выполняться;
1.2. Нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. Нить 3 должна каждые полсекунды выводить "Ура";
1.4. Нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. Нить 5 должна читать с консоли числа пока не введено слово "N", а потом вывести в консоль сумму введенных чисел.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.

Подсказка:
Нить 4 можно проверить методом isAlive()


Требования:
1. Статический блок класса Solution должен создавать и добавлять 5 нитей в список threads.
2. Нити из списка threads не должны стартовать автоматически.
3. Нить 1 из списка threads должна бесконечно выполняться.
4. Нить 2 из списка threads должна выводить "InterruptedException" при возникновении исключения InterruptedException.
5. Нить 3 из списка threads должна каждые полсекунды выводить "Ура".
6. Нить 4 из списка threads должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться.
7. Нить 5 из списка threads должна читать с консоли числа пока не введено слово "N", а потом вывести в консоль сумму введенных чисел.*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    public static void main(String[] args) {
        threads.add(new LoopRun());
        threads.add(new InteruptThread());
        threads.add(new WowThread());
        threads.add(new WarningThread());
        threads.add(new ReadConsoleThread());
        for (Thread th : threads) {
            th.start();
        }
    }

    public static class LoopRun extends Thread {
        public void run() {
            while (true) {
                try {
                    sleep(2000);
                    System.out.println(Thread.currentThread().getId() + " я Работаю");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public static class InteruptThread extends Thread {
        public void run() {
            try {
                sleep(1);
                System.out.println(Thread.currentThread().getId() + " я Работаю");
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class WowThread extends Thread {
        public void run() {
            while (true) {
                try {
                    sleep(500);
                    System.out.println("Ура");
                } catch (Exception e) {

                }

            }
        }
    }

    public static class WarningThread extends Thread implements Message {
        private boolean warning = false;

        public void run() {
            while (!warning) {

            }
        }

        @Override
        public void showWarning() {
            warning = true;
        }
    }

    public static class ReadConsoleThread extends Thread {
        private int tempInt = 0;
        private String tempString = "";

        public void run() {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            try {
                tempString = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                while (!tempString.equals("N")) {
                    tempInt += Integer.parseInt(tempString);
                    tempString = bufferedReader.readLine();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(tempInt);
        }
    }
}

