package com.javarush.task.task14.task1404;

/* 
Коты
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList <String> catsName = new ArrayList<String>();
        String inpputName;
        int i=0;
        Scanner scaner = new Scanner(System.in);
       do {
           inpputName = scaner.nextLine();
           if(!inpputName.equals("")){catsName.add(inpputName);}
       }while (!inpputName.equals(""));
        inpputName="";
        Cat[] catsArray = new Cat[catsName.size()];
        for(String inputName:catsName)
        {
            catsArray[i]=new Cat(inputName);
            catsArray[i] = CatFactory.getCatByKey(catsArray[i].name);
            System.out.println (catsArray[i].toString());
            i++;
        }
        //напишите тут ваш код
    }

    static class CatFactory {
        static Cat getCatByKey(String key) {
            Cat cat = null;
            if ("vaska".equals(key)) {
                cat = new MaleCat("Василий");
            } else if ("murka".equals(key)) {
                cat = new FemaleCat("Мурочка");
            } else if ("kiska".equals(key)) {
                cat = new FemaleCat("Кисюлька");
            } else {
                cat = new Cat(key);
            }
            return cat;
        }
    }

    static class Cat {
        private String name;

        protected Cat(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public String toString() {
            return "Я уличный кот " + getName();
        }
    }

    static class MaleCat extends Cat {
        MaleCat(String name) {
            super(name);
        }

        public String toString() {
            return "Я - солидный кошак по имени " + getName();
        }
    }

    static class FemaleCat extends Cat {
        FemaleCat(String name) {
            super(name);
        }

        public String toString() {
            return "Я - милая кошечка по имени " + getName();
        }
    }
}
