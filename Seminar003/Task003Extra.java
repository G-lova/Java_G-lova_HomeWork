package Seminar003;

import java.util.ArrayList;
import java.util.Random;

/*
 * Task003Extra.
 * Реализовать алгоритм сортировки массива слиянием (Дополнительное)
 */

public class Task003Extra {
    public static void main(String[] args) {
        ArrayList<Integer> listInt = new ArrayList<Integer>();
        fillRandomArray(15, 20, listInt);
        System.out.println(listInt);
        ArrayList<Integer> listSorted = new ArrayList<Integer>(listInt);
        System.out.println(mergeSort(listInt, listSorted, 0, listInt.size() - 1));

    }

    public static void fillRandomArray(int size, int max, ArrayList<Integer> list) {
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            list.add(rand.nextInt(max));
        }
    }

    public static ArrayList<Integer> mergeSort(ArrayList<Integer> list1, ArrayList<Integer> list2, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            list2.set(startIndex, list1.get(endIndex));
            return list2;
        }
        
        int middle = startIndex + (endIndex - startIndex) / 2;

        ArrayList<Integer> lList = mergeSort(list1, list2, startIndex, middle);
        ArrayList<Integer> rList = mergeSort(list1, list2, middle + 1, endIndex);

        ArrayList<Integer> target = lList == list1 ? list2 : list1;

        int lCur = startIndex, rCur = middle + 1;
        for (int i = startIndex; i <= endIndex; i++) {
            if (lCur <= middle && rCur <= endIndex) {
                if (lList.get(lCur) < rList.get(rCur)) {
                    target.set(i, lList.get(lCur));
                    lCur++;
                } else {
                    target.set(i, rList.get(rCur));
                    rCur++;
                }
            } else {
                if (lCur <= middle) {
                    target.set(i, lList.get(lCur));
                    lCur++;
                } else {
                    target.set(i, rList.get(rCur));
                    rCur++;
                }
            }
        }
        return target;
    }

}
