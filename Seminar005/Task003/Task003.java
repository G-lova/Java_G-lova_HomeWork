package Seminar005.Task003;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
 * Task003
 * На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга. И вывести Доску. 
 * Пример вывода доски 8x8
 * 
 * 0x000000
 * 0000x000
 * 00x00000
 */

public class Task003 {
    public static void main(String[] args) throws Exception {
        clearFile("Seminar005/Task003/Mat.txt");

        char[][] mat = new char[8][8];
        for (int i = 0; i < 8; i++) {
            Arrays.fill(mat[i], '0');
        }

        nQueen(mat, 0);

        Map<Integer, String> varMap = new HashMap<>();
        fillSolutionMap(varMap);
        printSolution(varMap);
    }

    private static void nQueen(char[][] mat, int r) {
        if (r == mat.length) {
            printSolutionIntoFile(mat);
            return;
        }
        for (int i = 0; i < mat.length; i++) {
            if (isSafe(mat, r, i)) {
                mat[r][i] = 'X';
                nQueen(mat, r + 1);
                mat[r][i] = '0';
            }
        }
    }

    private static boolean isSafe(char[][] mat, int r, int c) {
        for (int i = 0; i < r; i++) {
            if (mat[i][c] == 'X') {
                return false;
            }
        }
        for (int i = r, j = c; i >= 0 && j >= 0; i--, j--) {
            if (mat[i][j] == 'X') {
                return false;
            }
        }
        for (int i = r, j = c; i >= 0 && j < mat.length; i--, j++) {
            if (mat[i][j] == 'X') {
                return false;
            }
        }
        return true;
    }

    private static void clearFile(String path) {
        try (FileWriter fw = new FileWriter(path, false)) {
            fw.write("");
            fw.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printSolutionIntoFile(char[][] mat) {
        try (FileWriter fw = new FileWriter("Seminar005/Task003/Mat.txt", true)) {
            for (char[] chars : mat) {
                fw.write(Arrays.toString(chars).replaceAll(",", ""));
                fw.write("\n");
            }
            fw.write("\n");
            fw.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void fillSolutionMap(Map<Integer, String> map) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("Seminar005/Task003/Mat.txt"));
        String str;
        StringBuilder mat = new StringBuilder();
        int i = 1;
        int j = 0;
        while ((str = br.readLine()) != null) {
            if (i % 9 == 0) {
                map.put(j, mat.toString());
                mat.delete(0, mat.length());
                i++;
                j++;
            } else {
                mat.append(str + "\n");
                i++;
            }
        }
        br.close();
    }

    public static void printSolution(Map<Integer, String> map) {
        Random rand = new Random();
        int key = rand.nextInt(map.size());
        System.out.println(map.get(key));
    }

}
