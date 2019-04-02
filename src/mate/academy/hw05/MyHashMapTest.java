package mate.academy.hw05;

public class MyHashMapTest {

    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("Alex", 5);
        map.put("Ivan", 2);
        map.put("Max", 30);
        System.out.println(map);

        map.put("Max", 1);
        System.out.println(map);

        System.out.println(map.remove("Max"));
        System.out.println(map);

        System.out.println("MapSize = " + map.size());

        map.clear();
        System.out.println(map);

    }
}
