package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
Требования:
1. Программа должна считывать имя файла с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое файла (используй FileReader).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна выводить в консоль все теги, которые соответствуют тегу, заданному в параметре метода main.
*/


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName;
        String weFind = args[0];
        FileReader fileReader = null;
        ArrayList<String> allfindStrings = new ArrayList<String>();
        StringBuilder fullTextBuilder = new StringBuilder();
        String fullText = "";
        ArrayList<Integer> openTag = new ArrayList<>();
        ArrayList<Integer> closeTag = new ArrayList<>();
        TreeMap<Integer, Integer> openAndClose = new TreeMap();

        int i = 1;


        BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            fileName = fileNameReader.readLine();
            fileNameReader.close();
            fileReader = new FileReader(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (fileReader.ready()) {
            char oneChar = (char) fileReader.read();
            if (oneChar == 10 || oneChar == 13) continue;
            fullTextBuilder.append(oneChar);
        }
        fileReader.close();
        fullText = fullTextBuilder.toString();

        //Поиск пар тегов
        while (fullText.indexOf(weFind, i) > 0) {
            i = fullText.indexOf(weFind, i) + 1;
            if (fullText.substring(i - 2, i - 1).equals("<")) {
                openTag.add(i - 2);
                continue;
            }

            if (fullText.substring(i - 3, i - 1).equals("</")) {
                closeTag.add(i + weFind.length());
            }
        }

        for (int fill = 0; fill < openTag.size(); fill++) {
            allfindStrings.add("");
        }
        //Парсинг
        int ep = 0;
        for (int n = 0; n < openTag.size(); n++) {
            if ((openTag.get(n) >= closeTag.get(ep) && (openTag.size() != 1 && closeTag.size() != 1))) {
                openAndClose.put(openTag.get(n - 1), closeTag.get(ep));
                openTag.remove(n - 1);
                closeTag.remove(ep);
                n = 0;
            }
        }
        openAndClose.put(openTag.get(0), closeTag.get(0));
//конец поиска пары открытых и закрытых иегов
        for (Map.Entry<Integer, Integer> entry : openAndClose.entrySet()) {
            System.out.println(fullText.substring(entry.getKey(), entry.getValue()));
        }


    }
}
