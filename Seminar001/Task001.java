import java.util.Scanner;

/**
 * Task001
 * Вычислить n-ое треугольного число(сумма чисел от 1 до n), 
 * а так же n! (произведение чисел от 1 до n)
 */

public class Task001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.printf("Введите число: ");
        int n = sc.nextInt();
        sc.close();
        System.out.printf("Сумма чисел от 1 до %d = %d\n", n, sumN(n));
        System.out.printf("Факториал %d = %d\n", n, factorialN(n));
    }

    public static int sumN(int n) {
        if (n == 1) return 1;
        return n + sumN(n - 1);
    }

    public static int factorialN (int n) {
        if (n == 1) return 1;
        return n * factorialN(n - 1);
    }
}