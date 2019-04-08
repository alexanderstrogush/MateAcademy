package mate.academy.hw07.dao;

import mate.academy.hw07.di.Component;
import mate.academy.hw07.model.Human;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;

@Component
public class FileHumanDao implements HumanDao {

    @Override
    public void save(Human human) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("storage.dat"))) {
            objectOutputStream.writeObject(human);
        } catch (IOException e) {
            System.out.println("Не вдалося занести людину в базу даних");
        }
    }

    @Override
    public Human get() {
        try (ObjectInputStream inputObjectStream = new ObjectInputStream(new FileInputStream("people.dat"))) {
            return (Human) inputObjectStream.readObject();
        } catch (Exception e) {
            System.out.println("Людини не знайдено");
            return null;
        }
    }

    @Override
    public Human get(String name) {
        return get();
    }

    @Override
    public Human get(int index) {
        return get();
    }
}
