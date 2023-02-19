/**
 * Task002
 * Вывести все простые числа от 1 до 1000
 */

public class Task002 {
    public static void main(String[] args) {
        simpleNumbers(1000);
    }
        
    public static void simpleNumbers(int n) {
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    count++;
                    break;
                }
            }
            if (count == 0) 
                System.out.printf("%d ", i);
        }
    }
    
    
}
