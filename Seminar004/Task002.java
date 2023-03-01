package Seminar004;

import java.util.LinkedList;
import java.util.Scanner;

/*
 * Task002
 * Реализуйте очередь с помощью LinkedList со следующими методами:
 * enqueue() - помещает элемент в конец очереди,
 * dequeue() - возвращает первый элемент из очереди и удаляет его,
 * first() - возвращает первый элемент из очереди, не удаляя.
 */

public class Task002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "cp866");
        LinkedList<String> lList = new LinkedList<>();
        while (true) {
            System.out.println("1 - Добавить элемент в конец очереди");
            System.out.println("2 - Вывести первый элемент в очереди и удалить его");
            System.out.println("3 - Вывести первый элемент в очереди, не удаляя его");
            char num = sc.next().charAt(0);
            switch (num) {
                case '1':
                    enqueue(lList);
                    break;
                case '2':
                    dequeue(lList);
                    break;
                case '3':
                    first(lList);
                    break;
                default:
                    System.out.println("Нет такого варианта");
            }
        }   
    }

    public static void enqueue(LinkedList<String> list) {
        Scanner sc = new Scanner(System.in, "cp866");
        System.out.println("Введите элемент: ");
        list.add(sc.next());
        System.out.println(list);
    }

    public static void dequeue(LinkedList<String> list) {
        System.out.println(list.removeFirst());
        System.out.println(list);
    }

    public static void first(LinkedList<String> list) {
        System.out.println(list.peekFirst());
        System.out.println(list);
    }
}
