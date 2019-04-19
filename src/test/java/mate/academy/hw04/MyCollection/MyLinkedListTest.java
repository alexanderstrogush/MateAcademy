package mate.academy.hw04.MyCollection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyLinkedListTest {

    private List<String> expectedTestList = new MyLinkedList<>();
    private List<String> actualTestList;

    @Before
    public void initTestList() {
        expectedTestList.add("Max");
        expectedTestList.add("Alex");
        expectedTestList.add("Ivan");
    }

    @Test
    public void addTest() {
        actualTestList = new MyLinkedList<>();
        actualTestList.add("Max");

        Assert.assertEquals(1, actualTestList.size());

        actualTestList.add("Alex");
        actualTestList.add("Mason");

        Assert.assertEquals(3, actualTestList.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getTest() {
        Assert.assertEquals("Alex", expectedTestList.get(1));

        expectedTestList.get(25);
        expectedTestList.get(-15);
    }

    @Test
    public void setTest() {
        actualTestList = new MyLinkedList<>();
        actualTestList.add("Max");
        actualTestList.add("Alex");
        actualTestList.add("Mason");
        actualTestList.add("Ivan");

        actualTestList.set(3, "Vitold");

        Assert.assertEquals("Vitold", actualTestList.get(3));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeTest() {
        actualTestList = new MyLinkedList<>();
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