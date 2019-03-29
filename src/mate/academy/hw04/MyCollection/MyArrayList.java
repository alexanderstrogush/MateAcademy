package mate.academy.hw04.MyCollection;

public class MyArrayList<T> implements List<T> {

    private Object[] array;
    private int lenght;
    private int size = 0;

    public MyArrayList() {
        lenght = 15;
        array = new Object[lenght];
    }

    public MyArrayList(int length) {
        this.lenght = length;
        array = new Object[length];
    }

    @Override
    public void add(T value) {
        if (size < lenght) {
        } else {
            createLargerArray();
        }
        array[size++] = value;
    }

    @Override
    public void add(T value, int index) {
        if (size >= lenght) {
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
        return (T) array[index];
    }

    @Override
    public void set(int index, T value) {
        array[index] = value;
    }

    @Override
    public T remove(int index) {
        T removedElement = (T) array[index];
        copyArray(array, index + 1, size - index, array, index);
        size--;
        return removedElement;
    }

    @Override
    public void remove(T value) {
        boolean removed = false;
        for (int i = 0; i < size; i++) {
            if (value.equals(array[i])) {
                remove(i);
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println("There is no " + value.toString());
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
        int newLength = this.lenght * 2 + 1;
        Object[] buffer = new Object[newLength];
        copyArray(array, 0, size, buffer, 0);
        array = buffer;
        this.lenght = newLength;
    }

    private static void copyArray(Object[] startArray, int startIndex, int length, Object[] finalArray, int index) {
        for (int i = startIndex; i < startIndex + length; i++) {
            finalArray[index++] = startArray[i];
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            result.append((T) array[i].toString()).append(", ");
        }
        return result.toString();
    }
}
