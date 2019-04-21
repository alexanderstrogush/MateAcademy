package mate.academy.hw04.MyCollection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyArrayListTest {

    private List<String> expectedTestList = new MyArrayList<>();
    private List<String> actualTestList;

    @Before
    public void initTestList() {
        expectedTestList.add("Max");
        expectedTestList.add("Alex");
        expectedTestList.add("Ivan");
    }

    @Test
    public void addTest() {
        actualTestList = new MyArrayList<>();
        actualTestList.add("Max");
        actualTestList.add("Alex");
        actualTestList.add("Ivan");

        Assert.assertEquals(expectedTestList, actualTestList);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getTest() {
        Assert.assertEquals("Alex", expectedTestList.get(1));

        expectedTestList.get(-5);
        expectedTestList.get(25);
    }

    @Test
    public void setTest() {
        actualTestList = new MyArrayList<>();
        actualTestList.add("");
        actualTestList.add("Alex");
        actualTestList.add("Ivan");

        actualTestList.set(0, "Max");

        Assert.assertEquals(expectedTestList, actualTestList);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeTest() {
        actualTestList = new MyArrayList<>();
        actualTestList.add("Max");
        actualTestList.add("Alex");
        actualTestList.add("Mason");
        actualTestList.add("Ivan");

        actualTestList.remove(2);

        Assert.assertEquals(3, actualTestList.size());

        expectedTestList.remove(15);
    }

    @Test
    public void sizeTest() {
        Assert.assertEquals(3, expectedTestList.size());
    }

    @Test
    public void isEmptyTest() {
        Assert.assertFalse(expectedTestList.isEmpty());
    }
}