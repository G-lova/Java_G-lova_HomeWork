package Seminar002.Task004;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/**
 * Task004
 * К калькулятору из предыдущего дз добавить логирование.
 */

public class Task004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Введите число 1: ");
        float num1 = sc.nextFloat();
        System.out.printf("Введите символ операции: ");
        char operator = sc.next().charAt(0);
        System.out.printf("Введите число 2: ");
        float num2 = sc.nextFloat();
        sc.close();

        String result = calc(num1, num2, operator);
        System.out.println(result);

        StringBuilder logStr = new StringBuilder();
        logStr.append(num1).append(operator).append(num2).append(" ").append(result);
        logger(logStr.toString());
    }

    public static String calc(float num1, float num2, char operator) {
        float res;
        StringBuilder answer = new StringBuilder("");
        switch (operator) {
            case '+':
                res = num1 + num2;
                answer.append("Ваш ответ: ").append(res);
                break;
            case '-':
                res = num1 - num2;
                answer.append("Ваш ответ: ").append(res);
                break;
            case '*':
                res = num1 * num2;
                answer.append("Ваш ответ: ").append(res);
                break;
            case '/':
                res = num1 / num2;
                answer.append("Ваш ответ: ").append(res);
                break;
            default:
                answer.append("Ошибка");
                break;   
        }
        return answer.toString();
    }

    public static void logger(String info) {
        Date date = new Date();
        try (FileWriter fw = new FileWriter("Seminar002/Task004/log.txt", true)) {
            StringBuilder str = new StringBuilder(date.toString());
            str.append(": ").append(info);
            fw.write(str.toString());
            fw.write('\n');
            fw.flush();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }   
    }
}
