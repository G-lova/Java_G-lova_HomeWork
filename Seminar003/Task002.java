package Seminar003;

import java.util.ArrayList;
import java.util.Random;

/*
 * Task002.
 * Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее ариф. из этого списка
 */

public class Task002 {
    public static void main(String[] args) {
        ArrayList<Integer> listInt = new ArrayList<Integer>();
        fillRandomArray(15, 20, listInt);
        System.out.println(listInt);
        System.out.printf("Минимальный элемент %d\n", getMin(listInt));
        System.out.printf("Максимальный элемент %d\n", getMax(listInt));
        System.out.printf("Среднее арифметическое %f\n", averageMean(listInt));

    }

    public static void fillRandomArray(int size, int max, ArrayList<Integer> list) {
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            list.add(rand.nextInt(max));
        }
    }

    public static int getMin(ArrayList<Integer> list) {
        int min = list.get(0);
        for (Integer item : list) {
            if (item < min) {
                min = item;
            }
        }
        return min;
    }

    public static int getMax(ArrayList<Integer> list) {
        int max = list.get(0);
        for (Integer item : list) {
            if (item > max) {
                max = item;
            }
        }
        return max;
    }

    public static float averageMean(ArrayList<Integer> list) {
        float sum = 0;
        for (Integer item : list) {
            sum += item;
        }
        return sum/list.size();
    }
}
