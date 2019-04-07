package hw07.di;

import hw07.dao.FileHumanDao;
import hw07.dao.HumanDao;
import hw07.dao.InMemoryHumanDao;
import hw07.factory.HumanDaoFactory;
import hw07.handler.ConsoleHandler;

import java.lang.reflect.Field;

public class Injector {

    public static void injectDependency() throws IllegalAccessException {
        Class consoleHandlerClass = ConsoleHandler.class;
        Class fileHumanDaoClass = FileHumanDao.class;
        Class inMemoryDaoClass = InMemoryHumanDao.class;

        Field[] fields = consoleHandlerClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                boolean fileAccess = fileHumanDaoClass.isAnnotationPresent(Component.class);
                if (fileAccess) {
                    System.out.println("Робота з файлами дозволена");
                }
                boolean memoryAccess = inMemoryDaoClass.isAnnotationPresent(Component.class);
                if (memoryAccess) {
                    System.out.println("Робота з ОЗП дозволена");
                }
                HumanDao humanDao = HumanDaoFactory.getHumanDao(memoryAccess, fileAccess);
                field.set(null, humanDao);
            }
        }
    }
}
