package Seminar002.Task001;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/**
 * Task001
 * Реализуйте алгоритм сортировки пузырьком числового массива (введён вами),
 * результат после каждой итерации запишите в лог-файл.
 */

public class Task001 {
    public static void main(String[] args) throws IOException {
        // int[] array = new int[] { 6, 5, 4, 9, 1, 3 };
        Scanner sc = new Scanner(System.in);
        System.out.printf("Введите размер массива: ");
        int n = sc.nextInt();
        sc.close();
        int[] array = getArray(n, 10);
        System.out.println(Arrays.toString(array));
        int[] arraySorted = sorting(array);
        System.out.println(Arrays.toString(arraySorted));
    }
    
    public static int[] getArray(int size, int max) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(max);
        }
        return array;
    }

    private static int[] sorting(int[] array) {
        int count = 0;
        StringBuilder str = new StringBuilder("");
        while (count < array.length) {
            for (int i = 1; i < array.length - count; i++) {
                if (array[i] < array[i - 1]) {
                    int temp = array[i];
                    array[i] = array[i-1];
                    array[i-1] = temp;
                }
            }
            count++;
            str.append("Итерация ").append(Integer.toString(count)).append(": ");
            str.append(Arrays.toString(array)).append("\n");
        }
        logger(str.toString());
        return array;
    }

    public static void logger(String info) {
        Date date = new Date();
        try (FileWriter fw = new FileWriter("Seminar002/Task001/log.txt", true)) {
            StringBuilder str = new StringBuilder(date.toString());
            str.append(":\n").append(info);
            fw.write(str.toString());
            fw.write('\n');
            fw.flush();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }   
    }
}