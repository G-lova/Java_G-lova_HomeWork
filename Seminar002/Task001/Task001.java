package Seminar002.Task001;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

/**
 * Task001
 * Реализуйте алгоритм сортировки пузырьком числового массива (введён вами),
 * результат после каждой итерации запишите в лог-файл.
 */

public class Task001 {
    public static void main(String[] args) throws IOException {
        int[] array = new int[] { 6, 5, 4, 9, 1, 3 };
        int[] arraySorted = sorting(array);
        System.out.println(Arrays.toString(arraySorted));
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
            str.append("Итерация ");
            str.append(Integer.toString(count));
            str.append(": ");
            str.append(Arrays.toString(array));
            str.append("\n");
        }
        logger(str.toString());
        return array;
    }

    public static void logger(String info) {
        Date date = new Date();
        try (FileWriter fw = new FileWriter("Seminar002/Task001/log.txt", true)) {
            StringBuilder str = new StringBuilder(date.toString());
            str.append(":\n");
            str.append(info);
            fw.write(str.toString());
            fw.write('\n');
            fw.flush();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }   
    }
}