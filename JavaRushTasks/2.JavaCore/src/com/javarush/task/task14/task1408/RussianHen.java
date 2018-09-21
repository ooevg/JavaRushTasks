package com.javarush.task.task14.task1408;

public class RussianHen extends Hen {
    @Override
    int getCountOfEggsPerMonth() {
        return 3;
    }

    public String getDescription() {
        String returnString;
        returnString = String.format("%s Моя страна - %s . Я несу %s яиц в месяц.", super.getDescription(), Country.RUSSIA, this.getCountOfEggsPerMonth());
        return returnString;
    }
}
