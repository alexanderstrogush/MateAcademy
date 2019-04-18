package mate.academy.hw06.WorkWithSets;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
    public static void main(String[] args) {
        Set<String> firstSet = new HashSet<>();
        firstSet.add("White");
        firstSet.add("Black");
        firstSet.add("Red");
        System.out.println("FirstSet: " + firstSet);

        Set<String> secondSet = new HashSet<>();
        secondSet.add("Green");
        secondSet.add("Red");
        secondSet.add("White");
        System.out.println("SecondSet: " + secondSet);

        Set<String> result = symmetricDifference(firstSet, secondSet);
        System.out.println("Result: " + result);
    }

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> firstBuffer = new HashSet<>(set1);
        Set<T> secondBuffer = new HashSet<>(set2);
        firstBuffer.removeAll(set2);
        secondBuffer.removeAll(set1);
        firstBuffer.addAll(secondBuffer);
        return firstBuffer;
    }
}
