package mate.academy.hw06.Generics;

import java.util.Objects;

public class Pair<T, K> {

    private T firstElement;
    private K secondElement;

    private Pair(T firstElement, K secondElement) {
        this.firstElement = firstElement;
        this.secondElement = secondElement;
    }

    public T getFirst() {
        return firstElement;
    }

    public K getSecond() {
        return secondElement;
    }

    public static <T, K> Pair<T, K> of(T firstElement, K secondElement) {
        return new Pair(firstElement, secondElement);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(firstElement, pair.firstElement) &&
                Objects.equals(secondElement, pair.secondElement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstElement, secondElement);
    }
}
