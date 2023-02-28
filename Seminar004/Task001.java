package Seminar004;

import java.util.LinkedList;
import java.util.Random;

/**
 * Task001
 * Пусть дан LinkedList с несколькими элементами.
 * Реализуйте метод(не void), который вернет “перевернутый” список.
 */

public class Task001 {
    public static void main(String[] args) {
        LinkedList<Integer> lList = new LinkedList<>();
        fillRandomArray(10, 20, lList);
        System.out.println(lList);
        LinkedList<Integer> reverseList = reverse(lList);
        System.out.println(reverseList);

    }

    public static void fillRandomArray(int size, int max, LinkedList<Integer> list) {
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            list.add(rand.nextInt(max));
        }
    }

    public static LinkedList<Integer> reverse(LinkedList<Integer> lList) {
        LinkedList<Integer> reverseList = new LinkedList<>(lList);
        for (int i = 0; i < lList.size(); i++) {
            reverseList.set(lList.size() - 1 - i, lList.get(i));
        }
        return reverseList;
    }
}