package dao;

import model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

public class UserDaoTest {

    private UserDao userDao;
    private User expectedUser;

    @Before
    public void initialization() {
        userDao = new UserDao();
        expectedUser = new User("AlexStrog", "Olexandr", "Strog", "duric@gmail.com", "qwerty");
    }

    @Test
    public void userDaoTest() {
        userDao.addUser(expectedUser);
        User actualUser = userDao.getUser("AlexStrog").get();

        Assert.assertEquals(expectedUser, actualUser);

        expectedUser.setFirstName("Igor");
        userDao.updateUser(actualUser.getUser_id(), expectedUser);
        actualUser = userDao.getUser("AlexStrog").get();

        Assert.assertEquals(expectedUser, actualUser);

        userDao.deleteUser(actualUser.getUser_id());
        Assert.assertEquals(Optional.empty(), userDao.getUser("AlexStrog"));
    }

}