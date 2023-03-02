package Seminar005.Task002;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*
 * Task002
 * Пусть дан список сотрудников:
 * 
 * Иван Иванов
 * Светлана Петрова
 * Кристина Белова
 * Анна Мусина
 * Анна Крутова
 * Иван Юрин
 * Петр Лыков
 * Павел Чернов
 * Петр Чернышов
 * Мария Федорова
 * Марина Светлова
 * Мария Савина
 * Мария Рыкова
 * Марина Лугова
 * Анна Владимирова
 * Иван Мечников
 * Петр Петин
 * Иван Ежов
 * 
 * Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
 * Отсортировать по убыванию популярности Имени.
 */

public class Task002 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("Seminar005/Task002/File.txt"));
        String str;
        Map<String, Integer> map = new HashMap<>();
        while ((str = br.readLine()) != null) {
            String[] list = str.split(" ");
            if (!map.isEmpty()) {
                if (map.containsKey(list[0])) {
                    map.put(list[0], map.get(list[0]) + 1);
                } else {
                    map.put(list[0], 1);
                }
            } else {
                map.put(list[0], 1);
            }
        }
        br.close();
        sortOut(map);
    }

    public static void sortOut(Map<String, Integer> map) {
        LinkedList<Integer> list = new LinkedList<>(map.values());
        list.sort(null);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).equals(list.get(i - 1))) {
                list.remove(i);
                i--;
            }
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            for (String key : map.keySet()) {
                if (map.get(key).equals(list.get(i))) {
                    System.out.println(key + " " + list.get(i));
                }
            }
        }
    }
}
