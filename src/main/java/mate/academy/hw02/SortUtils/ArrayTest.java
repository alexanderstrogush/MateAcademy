package mate.academy.hw02.SortUtils;

import static mate.academy.hw02.SortUtils.SortUtils.*;

public class ArrayTest {
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
}
