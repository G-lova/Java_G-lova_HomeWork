package Seminar003;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * Task001
 * Пусть дан произвольный список целых чисел, удалить из него четные числа
 */

public class Task001 {
    public static void main(String[] args) {
        ArrayList<Integer> listInt = new ArrayList<Integer>();
        fillRandomArray(15, 20, listInt);
        System.out.println(listInt);
        modifArray(listInt);
        System.out.println(listInt);
    }

    public static void fillRandomArray(int size, int max, ArrayList<Integer> list) {
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            list.add(rand.nextInt(max));
        }
    }

    // Вариант 1.
    // public static void modifArray(ArrayList<Integer> list) {
    //     for (int i = 0; i < list.size(); i++) {
    //         if (list.get(i) % 2 == 0) {
    //             list.remove(list.get(i));
    //             i--;
    //         }
    //     }
    // }


    // Вариант 2.
    public static void modifArray(ArrayList<Integer> list) {
        Iterator<Integer> col = list.iterator();
        while (col.hasNext()) {
            if (col.next() % 2 == 0) {
                col.remove();
            }
        }
    }
}