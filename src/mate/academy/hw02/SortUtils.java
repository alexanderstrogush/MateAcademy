package mate.academy.hw02;

import java.util.Arrays;
import java.util.Random;

import static java.lang.System.arraycopy;

// Sorting
public class SortUtils {
    public static void main(String[] args) {
        System.out.println("Merge Sort");
        int[] arrayForMergeSort = createArray(20);
        printArray(arrayForMergeSort);
        arrayForMergeSort = mergeSort(arrayForMergeSort, 0, arrayForMergeSort.length);
        System.out.println("Sorted array:");
        printArray(arrayForMergeSort);

        System.out.println();

        System.out.println("Bubble Sort");
        int[] arrayForBubbleSort = createArray(20);
        printArray(arrayForBubbleSort);
        arrayForBubbleSort = bubbleSort(arrayForBubbleSort);
        System.out.println("Sorted array:");
        printArray(arrayForBubbleSort);

    }

    private static int[] merge(int[] firstArray, int[] secondArray) {
        int[] result = new int[firstArray.length + secondArray.length];
        int curentPosFirstArray = 0;
        int curentPosSecondArray = 0;
        int curentPosResultArray = 0;
        while ((curentPosFirstArray < firstArray.length) && (curentPosSecondArray < secondArray.length)) {
            result[curentPosResultArray++] = (firstArray[curentPosFirstArray] <= secondArray[curentPosSecondArray])
                    ? firstArray[curentPosFirstArray++]
                    : secondArray[curentPosSecondArray++];
        }
        if (curentPosFirstArray < firstArray.length) {
            arraycopy(firstArray, curentPosFirstArray, result, curentPosResultArray, firstArray.length - curentPosFirstArray);
        } else if (curentPosSecondArray < secondArray.length) {
            arraycopy(secondArray, curentPosSecondArray, result, curentPosResultArray, secondArray.length - curentPosSecondArray);
        }
        return result;
    }

    private static int[] mergeSort(int[] array, int lower, int upper) {
        int[] result;
        if (lower >= upper - 1) {
            return array;
        } else {
            int middle = (lower + upper) / 2;
            int[] leftArraysPart = Arrays.copyOfRange(array, 0, middle);
            int[] rightArraysPart = Arrays.copyOfRange(array, middle, upper);
            int[] sortedLeftPart = mergeSort(leftArraysPart, 0, leftArraysPart.length);
            int[] sortedRightPart = mergeSort(rightArraysPart, 0, rightArraysPart.length);
            result = merge(sortedLeftPart, sortedRightPart);
        }
        return result;
    }

    private static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
        return array;
    }

    private static void swap(int[] array, int firstPos, int secondPos) {
        int temp = array[firstPos];
        array[firstPos] = array[secondPos];
        array[secondPos] = temp;
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
