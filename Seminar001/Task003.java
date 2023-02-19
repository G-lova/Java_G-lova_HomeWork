import java.util.Scanner;

/**
 * Task003
 * Реализовать простой калькулятор (+ - / *)
 */

public class Task003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Введите число 1: ");
        float num1 = sc.nextFloat();
        System.out.printf("Введите символ операции: ");
        char operator = sc.next().charAt(0);
        System.out.printf("Введите число 2: ");
        float num2 = sc.nextFloat();
        sc.close();
        calc(num1, num2, operator);
    }

    public static void calc(float num1, float num2, char operator) {
        float res;
        switch (operator) {
            case '+':
                res = num1 + num2;
                System.out.printf("Ваш ответ: %f\n", res);
                break;
            case '-':
                res = num1 - num2;
                System.out.printf("Ваш ответ: %f\n", res);
                break;
            case '*':
                res = num1 * num2;
                System.out.printf("Ваш ответ: %f\n", res);
                break;
            case '/':
                res = num1 / num2;
                System.out.printf("Ваш ответ: %f\n", res);
                break;
            default:
                System.out.println("Ошибка");
                break;
            
        }
        

    }
}
