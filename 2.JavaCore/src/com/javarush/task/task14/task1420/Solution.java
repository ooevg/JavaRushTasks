package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            int a = getIntFromString(bufferedReader.readLine());
            int b = getIntFromString(bufferedReader.readLine());
            System.out.println("NOD between " + a + " and " + b + " is " + findNOD(a, b));
        } catch (NumberFormatException e) {
            System.out.println("We have NumberFormatException");
        }


    }

    public static int getIntFromString(String string) throws NumberFormatException {
        return Integer.parseInt(string);
    }

    public static int findNOD(int a, int b) {
        while (a != 0 && b != 0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }

        }
        return a + b;
    }
}
