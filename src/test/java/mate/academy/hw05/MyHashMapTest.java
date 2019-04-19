package mate.academy.hw05;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyHashMapTest {
    MyHashMap<String, Integer> expectedTestMap = new MyHashMap<>();
    MyHashMap<String, Integer> actualTestMap;

    @Before
    public void  initialization() {
        expectedTestMap.put("LIMO", 50);
    }

    @Test
    public void putTest() {
        actualTestMap = new MyHashMap<>();
        actualTestMap.put("LIMO", 50);

        int expected = 50;
        int actual = actualTestMap.get("LIMO");

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = NullPointerException.class)
    public void getTest() {
        int actual = expectedTestMap.get("LIMO");
        int expected = 50;

        Assert.assertEquals(expected, actual);
        expectedTestMap.get("LOL");
    }

    @Test(expected = NullPointerException.class)
    public void removeTest() {
        actualTestMap = new MyHashMap<>();
        actualTestMap.put("LIMO", 50);

        actualTestMap.remove("LIMO");


        Assert.assertEquals(0, actualTestMap.size());

        actualTestMap.remove("LOL");
    }

    @Test
    public void clearTest() {
        actualTestMap = new MyHashMap<>();
        actualTestMap.put("LIMO", 50);

        actualTestMap.clear();

        Assert.assertEquals(0, actualTestMap.size());
    }

    @Test
    public void size() {
        Assert.assertEquals(1, expectedTestMap.size());
    }
}