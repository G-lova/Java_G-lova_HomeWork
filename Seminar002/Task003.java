package Seminar002;

import java.util.Scanner;

/*
 * Task003
 * 3. Напишите метод, который принимает на вход строку (String) 
 * и определяет является ли строка палиндромом (возвращает boolean значение).
 */

public class Task003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Введите строку: ");
        String str = sc.nextLine();
        sc.close();
        System.out.println(ifPalindrom(str));
    }

    public static boolean ifPalindrom(String str) {
        boolean result = true;
        int count = 1;
        for (int i = 0; i < str.length()/2; i++) {
            if (str.charAt(i) == str.charAt(str.length()-count)) {
                count++;
            } else {
                result = false;
                break;
            }
        }
        return result;
    }
}
