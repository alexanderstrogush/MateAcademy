package mate.academy.hw01;

import java.util.Arrays;
import java.util.Random;

public class Sorting {
    public static void main(String[] args) {
        int[] arr = createArray(10);
        drawArray(arr);
        System.out.println("Bubble sort:");
        bubbleSort(arr);
        System.out.println();

        arr = createArray(10);
        drawArray(arr);
        System.out.println("Insertion sort:");
        insertionSort(arr);
        System.out.println();

        arr = createArray(10);
        drawArray(arr);
        System.out.println("Shaker sort:");
        shakerSort(arr);
        System.out.println();

    }

    private static int[] createArray(int n) {
        int[] arr = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(100);
        }
        return arr;
    }

    private static void drawArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
        System.out.println();
    }

    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int gar = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = gar;
                }
            }
        }
        drawArray(arr);
    }

    private static void insertionSort(int[] arr) {
        int temp, j;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                temp = arr[i + 1];
                arr[i + 1] = arr[i];
                j = i;
                while (j > 0 && temp < arr[j - 1]) {
                    arr[j] = arr[j - 1];
                    j--;
                }
                arr[j] = temp;
            }
        }
        drawArray(arr);
    }

    private static void shakerSort(int[] arr) {
        int buff;
        int left = 0;
        int right = arr.length - 1;
        do {
            for (int i = left; i < right; i++) {
                if (arr[i] > arr[i + 1]) {
                    buff = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buff;
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (arr[i] < arr[i - 1]) {
                    buff = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = buff;
                }
            }
            left++;
        } while (left < right);
        drawArray(arr);
    }
}
