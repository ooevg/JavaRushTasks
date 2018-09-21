package com.javarush.task.task14.task1408;

public class MoldovanHen extends Hen {
    @Override
    int getCountOfEggsPerMonth() {
        return 5;
    }

    public String getDescription() {
        String returnString;
        returnString = String.format("%s Моя страна - %s . Я несу %s яиц в месяц.", super.getDescription(), Country.MOLDOVA, this.getCountOfEggsPerMonth());
        return returnString;
    }
}
