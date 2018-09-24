package com.javarush.task.task14.task1417;

import com.javarush.task.task14.task1408.Hen;

public class Hrivna extends Money {
    public Hrivna(double amount) {
        super(amount);
    }

    @Override
    public String getCurrencyName() {
        return "UAH";
    }
}
