package com.javarush.task.task14.task1408;

/* 
Куриная фабрика
*/

public class Solution {
    public static void main(String[] args) {
        Hen hen = HenFactory.getHen(Country.BELARUS);
        hen.getCountOfEggsPerMonth();
    }

    static class HenFactory {

        static Hen getHen(String country) {
            Hen hen = null;
            //напишите тут ваш код
            return hen;
        }
    }

    public abstract class Hen
    {
        public abstract int getCountOfEggsPerMonth();
        public String getDescription(){return "Я курица";}

    }

    public class RussianHen extends Hen
    {   @Override
        public int getCountOfEggsPerMonth() {
            return 10;
        }
        @Override
        public String getDescription()
        {return super.getDescription()+"my country "+this.getClass()+ "Я несу "+this.getCountOfEggsPerMonth() +"яиц в месяц.";}
    }
    public class UkrainianHen extends Hen
    {

        @Override
        public int getCountOfEggsPerMonth() {
            return 9;
        }
        @Override
        public String getDescription()
        {return super.getDescription()+"my country "+this.getClass()+ "Я несу "+this.getCountOfEggsPerMonth() +"яиц в месяц.";}
    }
    public class MoldovanHen extends Hen
    {
        @Override
        public int getCountOfEggsPerMonth() {
            return 8;
        }
        @Override
        public String getDescription()
        {return super.getDescription()+"my country "+this.getClass()+ "Я несу "+this.getCountOfEggsPerMonth() +"яиц в месяц.";}
    }
    public class BelarusianHen extends Hen
    {
        @Override
        public int getCountOfEggsPerMonth() {
            return 7;
        }
        @Override
        public String getDescription()
        {return super.getDescription()+"my country "+this.getClass()+ "Я несу "+this.getCountOfEggsPerMonth() +"яиц в месяц.";}
    }


}
