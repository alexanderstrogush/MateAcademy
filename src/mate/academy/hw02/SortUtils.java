package mate.academy.hw02;

import java.util.Arrays;
import java.util.Random;

import static java.lang.System.arraycopy;

// Sorting
public class SortUtils {
    public static void main(String[] args) {
        System.out.println("Merge Sort");
        int[] array1 = createArray(20);
        printArray(array1);
        array1 = mergeSort(array1);
        System.out.println("Sorted array:");
        printArray(array1);

        System.out.println();

        System.out.println("Bubble Sort");
        int[] array2 = createArray(20);
        printArray(array2);
        array2 = bubbleSort(array2);
        System.out.println("Sorted array:");
        printArray(array2);
    }

    private static int[] merge(int[] array1, int[] array2) {
        int[] result = new int[array1.length + array2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while ((i < array1.length) && (j < array2.length)) {
            result[k++] = (array1[i] <= array2[j]) ? array1[i++] : array2[j++];
        }
        if (i < array1.length) {
            arraycopy(array1, i, result, k, array1.length - i);
        } else if (j < array2.length) {
            arraycopy(array2, j, result, k, array2.length - j);
        }
        return result;
    }

    private static int[] recMerrgeSort(int[] array, int lower, int upper) {
        int[] result;
        if (lower >= upper - 1) {
            return array;
        } else {
            int middle = (lower + upper) / 2;
            int[] buffer1 = Arrays.copyOfRange(array, 0, middle);
            int[] buffer2 = Arrays.copyOfRange(array, middle, upper);
            int[] sorted1 = recMerrgeSort(buffer1, 0, buffer1.length);
            int[] sorted2 = recMerrgeSort(buffer2, 0, buffer2.length);
            result = merge(sorted1, sorted2);
        }
        return result;
    }

    private static int[] mergeSort(int[] array) {
        array = recMerrgeSort(array, 0, array.length);
        return array;
    }

    private static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int gar = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = gar;
                }
            }
        }
        return array;
    }

    public static int[] createArray(int length) {
        int[] array = new int[length];
        if (length > 0) {
            Random random = new Random();
            for (int i = 0; i < length; i++) {
                array[i] = random.nextInt(10);
            }
        }
        return array;
    }

    public static void printArray(int[] array) {
        if (array.length > 0) {
            System.out.println(Arrays.toString(array));
        }
    }
}
