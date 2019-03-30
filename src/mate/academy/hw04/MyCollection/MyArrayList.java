package mate.academy.hw04.MyCollection;

public class MyArrayList<T> implements List<T> {

    private T[] array;
    private final int DEFAULT_LENGTH = 15;
    private int size = 0;

    public MyArrayList() {
        array = (T[]) new Object[DEFAULT_LENGTH];
    }

    public MyArrayList(int length) {
        array = (T[]) new Object[length];
    }

    @Override
    public void add(T value) {
        if (size < array.length) {
        } else {
            createLargerArray();
        }
        array[size++] = value;
    }

    @Override
    public void add(T value, int index) {
        checkIndex(index);
        if (size >= array.length) {
            createLargerArray();
        }
        Object[] firstBuffer = new Object[size - index];
        copyArray(array, index, size - index, firstBuffer, 0);
        array[index++] = value;
        copyArray(firstBuffer, 0, firstBuffer.length, array, index);
        size++;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return array[index];
    }

    @Override
    public void set(int index, T value) {
        checkIndex(index);
        array[index] = value;
    }

    @Override
    public T remove(int index) {
        checkIndex(index);
        T removedElement = array[index];
        copyArray(array, index + 1, size - index, array, index);
        size--;
        return removedElement;
    }

    @Override
    public void remove(T value) {
        for (int i = 0; i < size; i++) {
            if (value.equals(array[i])) {
                remove(i);
                break;
            }
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0) ? true : false;
    }

    private void createLargerArray() {
        int newLength = array.length * 2 + 1;
        T[] buffer = (T[]) new Object[newLength];
        copyArray(array, 0, size, buffer, 0);
        array = buffer;
    }

    private static void copyArray(Object[] startArray, int startIndex, int length, Object[] finalArray, int index) {
        for (int i = startIndex; i < startIndex + length; i++) {
            finalArray[index++] = startArray[i];
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(array[0].toString());
        for (int i = 0; i < size; i++) {
            result.append(", ").append((T) array[i].toString());
        }
        return result.toString();
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException("You went beyond the index");
        }
    }
}
