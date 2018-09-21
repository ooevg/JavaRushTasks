package com.javarush.task.task14.task1408;

public class BelarusianHen extends Hen {
    @Override
    int getCountOfEggsPerMonth() {
        return 6;
    }

    public String getDescription() {
        String returnString;
        returnString = String.format("%s Моя страна - %s . Я несу %s яиц в месяц.", super.getDescription(), Country.BELARUS, this.getCountOfEggsPerMonth());
        return returnString;
    }

}
