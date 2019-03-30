package mate.academy.hw04.MyCollection;

public class MyLinkedList<T> implements List<T> {

    private Node<T> firstNode = null;
    private Node<T> lastNode = null;
    private int size = 0;

    public Node<T> getFirstNode() {
        return firstNode;
    }

    public Node<T> getLastNode() {
        return lastNode;
    }

    @Override
    public void add(T value) {
        if (firstNode == null) {
            firstNode = new Node<>(value, null, null);
            lastNode = firstNode;
        } else {
            Node curentNode = new Node<>(value, lastNode, null);
            lastNode.next = curentNode;
            lastNode = curentNode;
        }
        size++;
    }

    @Override
    public void add(T value, int index) {
        checkIndex(index);
        Node<T> bufferNode = getNode(index);
        Node<T> newNode = new Node<>(value, bufferNode.prev, bufferNode);
        bufferNode.prev.next = newNode;
        bufferNode.prev = newNode;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        Node<T> requiredNode = firstNode;
        for (int i = 0; i < index; i++) {
            requiredNode = requiredNode.next;
        }
        return requiredNode.value;
    }

    public Node<T> getNode(int index) {
        checkIndex(index);
        Node<T> requiredNode = firstNode;
        for (int i = 0; i < index; i++) {
            requiredNode = requiredNode.next;
        }
        return requiredNode;
    }

    @Override
    public void set(int index, T value) {
        checkIndex(index);
        Node<T> bufferNode = getNode(index);
        bufferNode.value = value;
        bufferNode = null;
    }

    @Override
    public T remove(int index) {
        checkIndex(index);
        Node<T> bufferNode = getNode(index);
        if (index == 0) {
            firstNode = firstNode.next;
            firstNode.prev = null;
            bufferNode.next = null;
        } else {
            bufferNode.prev.next = bufferNode.next;
            bufferNode.next.prev = bufferNode.prev;
            bufferNode.prev = null;
            bufferNode.next = null;
        }
        size--;
        return bufferNode.value;
    }

    @Override
    public void remove(T value) {
        Node<T> bufferNode = firstNode;
        for (int i = 0; i < size; i++) {
            if (bufferNode.value.equals(value)) {
                remove(i);
                break;
            } else {
                bufferNode = bufferNode.next;
            }
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        Node<T> currentNode = firstNode;
        StringBuilder result = new StringBuilder(currentNode.value.toString());
        while (currentNode.next != null) {
            currentNode = currentNode.next;
            result.append(", ").append(currentNode.value.toString());
        }
        return result.toString();
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private class Node<T> {
        private T value;
        private Node prev;
        private Node next;

        public Node(T value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }
}
