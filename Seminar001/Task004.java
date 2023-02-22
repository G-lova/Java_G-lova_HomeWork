import java.util.Scanner;

/*
 * Task004Extra
 * *(ДОПОЛНИТЕЛЬНАЯ) Задано уравнение вида q + w = e, q, w, e >= 0. 
 * Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69 (пользователь).
 * Требуется восстановить выражение до верного равенства. 
 * Предложить хотя бы одно решение или сообщить, что его нет.
 */

public class Task004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "cp866");
        System.out.printf("Введите выражение: ");
        String expr = sc.nextLine();
        sc.close();

        int[] arrayOfIndex = arrayOfIndex(expr);
        char[][] arrayOfVar = ArrayOfVar(arrayOfIndex.length);
        newExpression(expr, arrayOfIndex, arrayOfVar);
    }

    public static int[] arrayOfIndex(String text) { 
        int count = 0;
        for (int i = 0; i < text.length(); i++)
            if (text.charAt(i) == '?')
                count++;
        int[] arrayOfIndex = new int[count];
        int j = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '?') {
                arrayOfIndex[j] = i;
                j++;
            }
        }
        return arrayOfIndex;
    }

    public static char[][] ArrayOfVar(int k) {
        char figures[] = new char[]{'0','1','2','3','4','5','6','7','8','9'};
        int n = figures.length;
        int pow[] = new int[k + 1];  
        pow[0] = 1;
        for (int i = 1; i <= k; i++) {
	        pow[i] = pow[i - 1] * n;
        }
        char[] array[] = new char[(int)(Math.pow(n, k))][k];
        for (int i = 0; i < pow[k]; i++) {    
            for (int j = 0; j < k; j++) {
                array[i][j] = figures[(i / pow[j]) % n];
            }
        }
        return array;
    }     

    public static String[] getList(String text) {
        String[] array = new String[3];
        String num = String.valueOf(text.charAt(0));
        int i = 0;
        for (int j = 1; j < text.length(); j++) {
            if ((Character.isDigit(text.charAt(j))) || (text.charAt(j) == '?')) {
                num += text.charAt(j);
            } else {
                if (num != "") {
                    array[i] = num;
                    num = "";
                    i++;
                }
            }
            array[i] = num;
        }
        return array;
    }

    public static void newExpression(String text, int[] arrayOfIndex, char[][] arrayOfVar) {
        String textNew = text;
        int count = 0;
        for (int i = 0; i < arrayOfVar.length; i++) {
            for (int j = 0; j < arrayOfVar[i].length; j++) {
                textNew = textNew.substring(0, arrayOfIndex[j]) + arrayOfVar[i][j] + textNew.substring(arrayOfIndex[j] + 1);
            }
            String[] arrayOfString = getList(textNew);
            if (Integer.parseInt(arrayOfString[0]) + Integer.parseInt(arrayOfString[1]) == Integer.parseInt(arrayOfString[2])) {
                count++;
                System.out.println(textNew);
            } 
        }
        if (count == 0)
            System.out.println("Решений нет");
    }

}
