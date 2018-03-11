package by.denis.console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class Calendar {
    private Integer year;
    private Integer month;
    private Integer day;

    private List<Integer> day31 = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 8, 10, 12));
    private List<Integer> day30 = new ArrayList<>(Arrays.asList(4, 6, 9, 11));


    public Calendar() {
    }

    public Calendar(Integer day, Integer month, Integer year) {
        if (isYear(year)) {
            this.year = year;
        } else {
            do {
                Printer.printPhrase("Enter year: ");
                this.year = Number.getInt();
            } while (!isYear(this.year));
        }
        if (isMonth(month)) {
            this.month = month;
        } else {
            do {
                Printer.printPhrase("Enter month: ");
                this.month = Number.getInt();
            } while (!isMonth(this.month));
        }
        if (isDay(day)) {
            this.day = day;
        } else {
            do {
                Printer.printPhrase("Enter day: ");
                this.day = Number.getInt();
            } while (!isDay(this.day));
        }
    }

    private boolean isYear(Integer year) {
        return year > 0;
    }

    private boolean isMonth(Integer month) {
        return month > 0 && month < 13;
    }

    private boolean isDay(Integer day) {
        if (isLeapYear(this.year)) {
            if (this.month == 2) {
                return day > 0 && day <= 29;
            } else if (day30.contains(this.month)) {
                return day > 0 && day <= 30;
            } else if (day31.contains(this.month)) {
                return day > 0 && day <= 31;
            }
        } else {
            if (this.month == 2) {
                return day > 0 && day <= 28;
            } else if (day30.contains(this.month)) {
                return day > 0 && day <= 30;
            } else if (day31.contains(this.month)) {
                return day > 0 && day <= 31;
            }
        }
        return false;
    }

    private static boolean isLeapYear(Integer year) {
        return year % 4 == 0 && (year % 400 == 0 || year % 100 != 0);
    }

    public void printFullDate() {
        StringJoiner sj = new StringJoiner(".");
        sj.add(this.day.toString()).add(this.month.toString()).add(this.year.toString());
        Printer.printPhrase(sj.toString());
    }


    public Calendar getNextDay() {
        Calendar result = new Calendar(this.day, this.month, this.year);
        result.plusDay();
        return result;
    }

    public void plusDay() {
        if (isLeapYear(this.year)) {
            if (this.month == 2) {
                addDay29();
            } else if (day30.contains(this.month)) {
                addDay30();
            } else if (day31.contains(this.month)) {
                addDay31();
            }
        } else {
            if (this.month == 2) {
                addDay28();
            } else if (day30.contains(this.month)) {
                addDay30();
            } else if (day31.contains(this.month)) {
                addDay31();
            }
        }
    }

    private void addDay28() {
        if (this.day == 28) {
            this.month += 1;
            this.day = 1;
        } else {
            this.day += 1;
        }
    }

    private void addDay29() {
        if (this.day == 29) {
            this.month += 1;
            this.day = 1;
        } else {
            this.day += 1;
        }
    }

    private void addDay30() {
        if (this.day == 30) {
            this.month += 1;
            this.day = 1;
        } else {
            this.day += 1;
        }
    }

    private void addDay31() {
        if (this.day == 31) {
            if (this.month == 12) {
                this.year += 1;
                this.month = 1;
                this.day = 1;
            } else {
                this.month += 1;
                this.day = 1;
            }
        } else {
            this.day += 1;
        }
    }


    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }
}
