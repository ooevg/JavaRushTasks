package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;
        String inputString = reader.readLine();
        //тут цикл по чтению ключей, пункт 1
        while (checkInput(inputString)) {
            //создаем объект, пункт 2
            switch (inputString) {
                case "user":
                    person = new Person.User();
                    break;
                case "loser":
                    person = new Person.Loser();
                    break;
                case "coder":
                    person = new Person.Coder();
                    break;
                case "proger":
                    person = new Person.Proger();
                    break;
            }
            doWork(person); //вызываем doWork
            inputString = reader.readLine();

        }
    }

    public static boolean checkInput(String vvod) {
        if (vvod.equals("user") || vvod.equals("loser") || vvod.equals("coder") || vvod.equals("proger")) {
            return true;
        } else
            return false;
    }

    public static void doWork(Person person) {
        if (person instanceof Person.User) {
            ((Person.User) person).live();
        }
        if (person instanceof Person.Coder) {
            ((Person.Coder) person).coding();
        }
        if (person instanceof Person.Loser) {
            ((Person.Loser) person).doNothing();
        }
        if (person instanceof Person.Proger) {
            ((Person.Proger) person).enjoy();
        }

    }
    // пункт 3

}
