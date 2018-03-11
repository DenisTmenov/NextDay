package by.denis.bean;

import by.denis.console.Calendar;

public class Main {

    public static void main(String[] args) {
        Calendar myBirthDay = new Calendar(213123, 44, 1988);
        myBirthDay.printFullDate();
        myBirthDay.plusDay();
        myBirthDay.printFullDate();

    }
}
