package model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTest {

    User testUser;

    @Before
    public void init() {
        testUser = new User("AlexStrog", "Olexandr",
                "Strogush", "gaymar26@gmail.com", "qwerty");
    }

    @Test
    public void getUserNameTest() {
        Assert.assertEquals("AlexStrog", testUser.getUserName());
    }

    @Test
    public void getFirsNameTest() {
        Assert.assertEquals("Olexandr", testUser.getFirsName());
    }

    @Test
    public void getLastNameTest() {
        Assert.assertEquals("Strogush", testUser.getLastName());
    }

    @Test
    public void getEmailTest() {
        Assert.assertEquals("gaymar26@gmail.com", testUser.getEmail());
    }

    @Test
    public void getPasswordTest() {
        Assert.assertEquals("qwerty", testUser.getPassword());
    }
}