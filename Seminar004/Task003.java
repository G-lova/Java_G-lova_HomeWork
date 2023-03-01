package Seminar004;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Task003
 * В калькулятор добавьте возможность отменить последнюю операцию.
 * Пример
 * 1
 * +
 * 2
 * ответ:
 * 3
 * +
 * 4
 * ответ:
 * 7
 * Отмена
 * 3
 *
 * 3
 * ответ:
 * 9
 * Дополнительно каскадная отмена - отмена нескольких операций
 */

public class Task003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "cp866");
        LinkedList<String> calc = new LinkedList<>();

        while (true) {
            System.out.printf("Введите число 1: ");
            calc.add(sc.nextLine());

            while (true) {
                System.out.printf("Введите символ операции: ");
                calc.add(sc.nextLine());
                if (calc.getLast().toLowerCase().equals("отмена")) {
                    if (calc.size() < 3) {
                        calc.clear();
                        break;
                    } else {
                        while (calc.getLast().toLowerCase().equals("отмена")) {
                            calc.removeLast();
                            calc.removeLast();
                            calc.removeLast();
                            System.out.println(calc.get(calc.size() - 2));
                            System.out.println(calc.peekLast());
                            break;
                        }
                    }
                }

                while (true) {
                    System.out.printf("Введите число 2: ");
                    calc.add(sc.nextLine());

                    if (calc.getLast().toLowerCase().equals("отмена")) {
                        calc.removeLast();
                        calc.removeLast();
                        System.out.println(calc.peekLast());
                        break;
                    }

                    calcProcess(calc);
                    break;
                }
            }
        }
    }

    public static void calcProcess(LinkedList<String> list) {
        StringBuilder answer = new StringBuilder("");
        switch (list.get(list.size() - 2).toString().charAt(0)) {
            case '+':
                list.add(Float.toString(Float.valueOf(list.get(list.size()-3)) + Float.valueOf(list.getLast())));
                System.out.println(answer.append("Ответ: ").append(list.getLast()));
                break;
            case '-':
                list.add(Float.toString(Float.valueOf(list.get(list.size()-3)) - Float.valueOf(list.getLast())));
                System.out.println(answer.append("Ответ: ").append(list.getLast()));
                break;
            case '*':
                list.add(Float.toString(Float.valueOf(list.get(list.size()-3)) * Float.valueOf(list.getLast())));
                System.out.println(answer.append("Ответ: ").append(list.getLast()));
                break;
            case '/':
                list.add(Float.toString(Float.valueOf(list.get(list.size()-3)) / Float.valueOf(list.getLast())));
                System.out.println(answer.append("Ответ: ").append(list.getLast()));
                break;
            default:
                System.out.println(answer.append("Ошибка"));
                list.removeLast();
                list.removeLast();
                System.out.println(list.getLast());
                break;
        }
    }
}
