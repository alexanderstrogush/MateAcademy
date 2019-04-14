package mate.academy.hw07.factory;

import mate.academy.hw07.dao.FileHumanDao;
import mate.academy.hw07.dao.HumanDao;
import mate.academy.hw07.dao.InMemoryHumanDao;
import mate.academy.hw07.exeption.ComponentNotFoundException;
import mate.academy.hw07.service.PropertiesLoader;

import java.io.IOException;

public class HumanDaoFactory {

    private static final HumanDao fileHumanDao = new FileHumanDao();
    private static final HumanDao inMemoryHumanDao = new InMemoryHumanDao();

    public static HumanDao getHumanDao(boolean memoryAccess, boolean fileAccess) {
        try {
            String dbType = PropertiesLoader.getProperty("db.type");
            if (dbType.equals("memory") && memoryAccess) {
                return inMemoryHumanDao;
            }
        } catch (IOException e) {
            System.out.println("Немає доступу до файлу!");
        }
        if (fileAccess) {
            return fileHumanDao;
        } else {
            throw new ComponentNotFoundException();
        }
    }
}
