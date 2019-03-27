package mate.academy.hw03.MergeArrays;

import java.util.Arrays;

public class MergeTest {
    public static void main(String[] args) {
        int[] array1 = {2, 6, 7, 8, 10};
        int[] array2 = {4, 5, 9, 12, 20};

        System.out.println("ArrayA : " + Arrays.toString(array1));
        System.out.println("ArrayB : " + Arrays.toString(array2));
        int[] result = MergeArrays.mergeArrays(array1, array2);
        System.out.println("ArrayA + ArrayB = " + Arrays.toString(result));
    }
}
