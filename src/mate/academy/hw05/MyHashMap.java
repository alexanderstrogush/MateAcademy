package mate.academy.hw05;

import java.util.LinkedList;
import java.util.Objects;

public class MyHashMap<T, K> {
    private final int DEFAULT_CAPACITY = 10;
    private LinkedList<Box>[] table;
    private int size = 0;

    public MyHashMap() {
        table = new LinkedList[DEFAULT_CAPACITY];
    }

    public MyHashMap(int capacity) {
        table = new LinkedList[capacity];
    }

    public void put(T key, K value) {
        int hash = key.hashCode();
        int position = getPosition(key);
        Box buffer = new Box(hash, key, value);
        if (table[position] == null) {
            table[position] = new LinkedList<>();
            table[position].add(buffer);
            size++;
        } else {
            if (table[position].contains(new Box(key))) {
                int pos = table[position].indexOf(new Box(key));
                table[position].get(pos).value = value;
            } else {
                table[position].add(buffer);
                size++;
            }
        }
    }

    public K get(T key) {
        checkKey(key);
        int resultIndex;
        resultIndex = table[getPosition(key)]
                .indexOf(new Box(key));
        return (K) table[getPosition(key)].get(resultIndex).value;
    }

    private int getPosition(T key) {
        int keyHash = key.hashCode();
        return keyHash % table.length;
    }

    public K remove(T key) {
        checkKey(key);
        K result = get(key);
        table[getPosition(key)].remove(new Box(key));
        if (table[getPosition(key)].isEmpty()) {
            table[getPosition(key)] = null;
        }
        size--;
        return result;
    }

    private boolean checkKey(T key) {
        boolean check = false;
        search:
        for (LinkedList<Box> list : table) {
            if (list == null) {
                continue;
            }
            for (Box box : list) {
                if (box.equals(new Box(key))) {
                    check = true;
                    break search;
                }
            }
        }
        if (!check) {
            throw new NullPointerException("The key does not exist");
        }
        return check;
    }

    public void clear() {
        table = new LinkedList[table.length];
    }

    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        String result;
        StringBuilder buffer = new StringBuilder();
        for (LinkedList<Box> list : table) {
            if (list == null) {
                continue;
            }
            buffer.append(list).append(", ");
        }
        if (buffer.length() == 0) {
            result = "( )";
        } else {
            result = buffer.substring(0, buffer.length() - 2);
        }
        return result;
    }

    private class Box<T, K> {
        private int hash;
        private T key;
        private K value;

        public Box(T key) {
            this.key = key;
        }

        public Box(int hash, T key, K value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Box<?, ?> box = (Box<?, ?>) o;
            return Objects.equals(key, box.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(hash, key, value);
        }

        @Override
        public String toString() {
            return "{" + key + "} = " + value;
        }
    }
}
