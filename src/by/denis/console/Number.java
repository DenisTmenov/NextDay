package by.denis.console;

import java.util.Scanner;

class Number {
    private static Scanner scanner = new Scanner(System.in);

    static int getInt() {
        String word;
        do {
            word = scanner.next();
        } while (!isInt(word));
        return Integer.valueOf(word);
    }

    private static boolean isInt(String word) {
        try {
            Integer a = Integer.valueOf(word);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
