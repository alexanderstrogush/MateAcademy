package mate.academy.hw04.MyCollection;

public interface List<T> {

    void add(T value); // Y

    void add(T value, int index); // T

    default void addAll(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            add(list.get(i));
        }
    }

    T get(int index); // Y

    void set(int index, T value); // Y

    T remove(int index); // возвращаем элемент, который удалили  Y

    void remove(T value); // удалять первый, который встретится

    int size(); // Y

    boolean isEmpty(); // Y
}
