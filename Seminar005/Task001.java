package Seminar005;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

/**
 * Task001
 * Реализуйте структуру телефонной книги с помощью HashMap, учитывая, 
 * что 1 человек может иметь несколько телефонов.
 * Добавить функции:
 * 1) Добавление номера
 * 2) Вывод всего
 */

public class Task001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "cp866");
        Map<Integer, String> map = new HashMap<>();

        while (true) {
            System.out.println("1 - Добавить контакт");
            System.out.println("2 - Просмотр контактов");
            System.out.println("3 - Выход");
            switch (sc.nextInt()) {
                case 1:
                    add(map);
                    break;
                case 2:
                    out(map);
                    break;
                case 3:
                    sc.close();
                    break;
                default:
                    System.out.println("Ошибка");
                    break;
            }
        }
    }

    public static void add(Map<Integer, String> map) {
        Scanner sc = new Scanner(System.in, "cp866");
        System.out.println("Введите имя: ");
        String name = sc.next();
        System.out.println("Введите номер телефона: ");
        int phone = sc.nextInt();
        map.put(phone, name);
    }

    public static void out(Map<Integer, String> map) {
        LinkedList<String> list = new LinkedList<>(map.values());
        list.sort(null);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).equals(list.get(i-1))) {
                list.remove(i);
                i--;
            }
        }
        for (String item : list) {
            System.out.println(item);
            for (Integer key : map.keySet()) {
                if (map.get(key).equals(item)){
                    System.out.println(" == " + key);
                }
            }
        }
    }
}