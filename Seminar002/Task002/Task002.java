package Seminar002.Task002;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Task002
 * Дана строка (получение через обычный текстовый файл!!!)

"фамилия":"Иванов","оценка":"5","предмет":"Математика"
"фамилия":"Петрова","оценка":"4","предмет":"Информатика"

Написать метод(ы), который распарсит строку и, используя StringBuilder, создаст строки вида:
Студент [фамилия] получил [оценка] по предмету [предмет].

Пример вывода:
Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика.
 */

public class Task002 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("Seminar002/Task002/BD.txt"));
        String str;
        while ((str = br.readLine()) != null) {
            System.out.printf("%s\n", newString(str));
        }
        br.close();
    }

    public static String newString(String str) {
        String[] strArr = str.split(",");
        for (int i = 0; i < strArr.length; i++) {
            for (int j = 0; j < strArr[i].length(); j++) {
                if (strArr[i].charAt(j) == ':') {
                    strArr[i] = strArr[i].substring(j+2, strArr[i].length()-1);
                    break;
                }
            }
        }
        StringBuilder line = new StringBuilder("");
        line.append("Студент ").append(strArr[0]).append(" получил ");
        line.append(strArr[1]).append(" по предмету ").append(strArr[2]);
        return line.toString();
    }

}