package mate.academy.hw03.MergeArrays;

import java.util.Arrays;

import static mate.academy.hw03.MergeArrays.MergeArrays.*;

public class Test {
    public static void main(String[] args) {
        int[] array1 = {2, 6, 7, 8, 10};
        int[] array2 = {4, 5, 9, 12, 20};
        int[] result = mergeArrays(array1, array2);
        System.out.println(Arrays.toString(result));

    }
}
