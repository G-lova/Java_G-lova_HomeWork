import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        ArrayList<Notebook> nbList = notebookArray();
        Map<Integer, ArrayList> parametrMap = parametrMap(nbList);
        filtrNB(parametrMap, nbList);
    }

    public static ArrayList<Notebook> notebookArray() {
        Notebook nb1 = new Notebook("F9GF354", "Asus", 16, 512, "Windows", "black");
        Notebook nb2 = new Notebook("G5BJ6546", "HP", 8, 128, "Windows", "gray");
        Notebook nb3 = new Notebook("I65LH566", "Acer", 32, 512, "Linux", "black");
        Notebook nb4 = new Notebook("HG654HG456", "Apple", 32, 1024, "MacOS", "silver");
        Notebook nb5 = new Notebook("H654G988", "Dell", 16, 1024, "Windows", "white");
        return new ArrayList<Notebook>(Arrays.asList(nb1, nb2, nb3, nb4, nb5));
    }

    public static Map<Integer, ArrayList> parametrMap(ArrayList<Notebook> nbList) {
        HashSet<Integer> ozuSet = new HashSet<>();
        for (Notebook nb : nbList) {
            ozuSet.add(nb.ozu);
        }

        HashSet<Integer> zdSet = new HashSet<>();
        for (Notebook nb : nbList) {
            zdSet.add(nb.zd);
        }

        HashSet<String> osSet = new HashSet<>();
        for (Notebook nb : nbList) {
            osSet.add(nb.os);
        }

        HashSet<String> colorSet = new HashSet<>();
        for (Notebook nb : nbList) {
            colorSet.add(nb.color);
        }

        ArrayList<Integer> ozuList = new ArrayList<>(ozuSet);
        ArrayList<Integer> zdList = new ArrayList<>(zdSet);
        ArrayList<String> osList = new ArrayList<>(osSet);
        ArrayList<String> colorList = new ArrayList<>(colorSet);

        Map<Integer, ArrayList> parametrMap = new HashMap<>();
        parametrMap.put(1, ozuList);
        parametrMap.put(2, zdList);
        parametrMap.put(3, osList);
        parametrMap.put(4, colorList);
        return parametrMap;
    }

    public static void filtrNB(Map<Integer, ArrayList> map, ArrayList<Notebook> nbList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Выберите параметр фильтрации:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");
        int parametr = sc.nextInt();
        System.out.println("Выберите значение параметра");
        for (int i = 0; i < map.get(parametr).size(); i++) {
            System.out.println(i + 1 + " - " + map.get(parametr).get(i));
        }
        int parametrVal = sc.nextInt();
        for (Notebook nb : nbList) {
            if (nb.alike(map.get(parametr).get(parametrVal-1)) == true) {
                System.out.println(nb.toString());
            }
        }

    }
}
