package com.javarush.task.task17.task1710;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        Object[] objects;
        Person person = null;
        switch (args[0]) {
            case "-c":
                objects = parseParams(args);
                switch ((Sex) objects[1]) {
                    case MALE:
                        person = Person.createMale((String) objects[0], (Date) objects[2]);
                        allPeople.add(person);
                        break;
                    case FEMALE:
                        person = Person.createFemale((String) objects[0], (Date) objects[2]);
                        allPeople.add(person);
                        break;
                }
                System.out.println(allPeople.indexOf(person));
                break;
            case "-u":
                objects = parseParams(args);
                person = allPeople.get(Integer.parseInt(args[1]));
                person.setName((String) objects[0]);
                person.setSex((Sex) objects[1]);
                person.setBirthDay((Date) objects[2]);
                break;
            case "-d":
                allPeople.remove(Integer.parseInt(args[1]));
                break;
            case "-i":
                StringBuffer stringBuffer = new StringBuffer();
                person = allPeople.get(Integer.parseInt(args[1]));
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                stringBuffer.append(person.getName()).append(" ").append((person.getSex().equals(Sex.MALE) ? "м" : "ж")).append(" ").append(dateFormat.format(person.getBirthDay()));
                System.out.println(stringBuffer);
                break;
        }


    }

    private static Object[] parseParams(String[] args) {
        String name = args[1];
        Sex sex;
        Date birthday = null;
        Object[] objects = new Object[3];

        if (args[2].equals("м")) sex = Sex.MALE;
        else sex = Sex.FEMALE;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy", Locale.ENGLISH);

        try {
            birthday = dateFormat.parse(args[3]);
        } catch (Exception e) {
        }
        objects[0] = name;
        objects[1] = sex;
        objects[2] = birthday;
        return objects;
    }

    ;
}
