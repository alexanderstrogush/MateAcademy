package mate.academy.hw01;

import java.util.Arrays;
import java.util.Random;

public class TaskWithArray {
    public static void main(String[] args) {
        int[][] array = createArray(3, 4);
        System.out.println(Arrays.deepToString(array));
        minMax(array);
    }

    private static int[][] createArray(int rows, int columns) {
        int[][] array = new int[rows][columns];
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array[i][j] = random.nextInt(100);
            }
        }
        return array;
    }

    private static void minMax(int[][] array) {
        int min = array[0][0];
        int max = min;

        for (int[] i : array) {
            for (int j : i) {
                if (j >= max) {
                    max = j;
                } else if (j <= min) {
                    min = j;
                }
            }
        }
        System.out.println("Max = " + max);
        System.out.println("Min = " + min);
    }
}
