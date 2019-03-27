package mate.academy.hw03.MergeArrays;

import java.util.Random;

public class MergeArrays {

    public static int[] mergeArrays(int[] firstArray, int[] secondArray) {
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
            System.arraycopy(firstArray, curentPosFirstArray, result, curentPosResultArray, firstArray.length - curentPosFirstArray);
        } else if (curentPosSecondArray < secondArray.length) {
            System.arraycopy(secondArray, curentPosSecondArray, result, curentPosResultArray, secondArray.length - curentPosSecondArray);
        }
        return result;
    }
}
