package mate.academy.hw04;

import mate.academy.hw04.MyCollection.MyLinkedList;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<String> myLinkedList1 = new MyLinkedList<>();

        myLinkedList1.add("Hello");
        myLinkedList1.add("I");
        myLinkedList1.add("am");
        myLinkedList1.add("Alex");

        System.out.println(myLinkedList1); // Hello, I, am, Alex

        myLinkedList1.add("everybody", 1);
        System.out.println(myLinkedList1); // Hello, everybody, I, am, Alex

        MyLinkedList<String> myLinkedList2 = new MyLinkedList<>();
        myLinkedList2.add("I");
        myLinkedList2.add("finish");

        myLinkedList1.addAll(myLinkedList2);
        System.out.println(myLinkedList1); // Hello, everybody, I, am, Alex, I, finish

        myLinkedList1.set(6, "end");
        System.out.println(myLinkedList1); // Hello, everybody, I, am, Alex, I, end

        myLinkedList1.remove(0);
        System.out.println(myLinkedList1); // everybody, I, am, Alex, I, end

        myLinkedList1.remove("I");
        System.out.println(myLinkedList1); // everybody, am, Alex, I, end

        System.out.println("MyLinkedList1[4] = " + myLinkedList1.get(4)); // MyLinkedList1[4] = end
        System.out.println("Is MyLinkedList1 empty?: " + myLinkedList1.isEmpty()); // Is MyLinkedList1 empty?: false
        System.out.println("Size of MyLinkedList1 = " + myLinkedList1.size()); // Size of MyLinkedList1 = 4
    }
}
