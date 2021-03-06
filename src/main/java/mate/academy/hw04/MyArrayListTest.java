package mate.academy.hw04;

import mate.academy.hw04.MyCollection.List;
import mate.academy.hw04.MyCollection.MyArrayList;
import mate.academy.hw04.MyCollection.MyLinkedList;

public class MyArrayListTest {
    public static void main(String[] args) {
        List<String> myArrayList1 = new MyArrayList<>();

        myArrayList1.add("Hello");
        myArrayList1.add("I");
        myArrayList1.add("am");
        myArrayList1.add("Alex");

        System.out.println(myArrayList1); // Hello, I, am, Alex

        myArrayList1.add("everybody", 1);
        System.out.println(myArrayList1); // Hello, everybody, I, am, Alex

        List<String> myArrayList2 = new MyLinkedList<>();
        myArrayList2.add("I");
        myArrayList2.add("finish");

        myArrayList1.addAll(myArrayList2);
        System.out.println(myArrayList1); // Hello, everybody, I, am, Alex, I, finish

        myArrayList1.set(6, "end");
        System.out.println(myArrayList1); // Hello, everybody, I, am, Alex, I, end

        myArrayList1.remove(0);
        System.out.println(myArrayList1); // everybody, I, am, Alex, I, end

        myArrayList1.remove("I");
        System.out.println(myArrayList1); // everybody, am, Alex, I, end

        System.out.println("MyArrayList1[4] = " + myArrayList1.get(4)); // MyArrayList1[4] = end
        System.out.println("Is MyArrayList1 empty?: " + myArrayList1.isEmpty()); // Is MyArrayList1 empty?: false
        System.out.println("Size of MyArrayList1 = " + myArrayList1.size()); // Size of MyArrayList1 = 4
    }
}
