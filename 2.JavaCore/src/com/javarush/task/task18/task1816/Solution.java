package com.javarush.task.task18.task1816;

/* 
Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв).
Закрыть потоки.


Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток чтения из файла, который приходит первым параметром в main.
3. В файле необходимо посчитать буквы английского алфавита и вывести это число в консоль.
4. Нужно учитывать заглавные и строчные буквы.
5. Поток чтения из файла должен быть закрыт.
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        int englishCharsCount = 0;
        int oneChar;
        String filename;
        BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in));
        filename = fileNameReader.readLine();
        FileInputStream fileInputStream = new FileInputStream(filename);
        fileNameReader.close();
        while (fileInputStream.available() > 0) {
            oneChar = fileInputStream.read();
            if ((oneChar >= 65 && oneChar <= 90) || (oneChar >= 97 && oneChar <= 122)) englishCharsCount++;
        }

        fileInputStream.close();

        System.out.println(englishCharsCount);
    }
}
