package com.javarush.task.task14.task1408;

public class UkrainianHen extends Hen {
    @Override
    int getCountOfEggsPerMonth() {
        return 4;
    }

    public String getDescription() {
        String returnString;
        returnString = String.format("%s Моя страна - %s . Я несу %s яиц в месяц.", super.getDescription(), Country.UKRAINE, this.getCountOfEggsPerMonth());
        return returnString;
    }
}
