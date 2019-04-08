package mate.academy.hw07.dao;


import mate.academy.hw07.di.Component;
import mate.academy.hw07.model.Human;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Component
public class InMemoryHumanDao implements HumanDao {

    private static final List<Human> peopleStorage = new ArrayList<>();

    @Override
    public void save(Human human) {
        peopleStorage.add(human);
    }

    @Override
    public Human get() {
        System.out.println("В базі даних присутня інформація про :");
//        for (Human human : peopleStorage) {
//            System.out.println(human);
//        }
        peopleStorage.stream().forEach(System.out::println);
        throw new NoSuchElementException("База даних пуста");
    }

    public Human get(int index) {
        return peopleStorage.get(index - 1);
    }

    @Override
    public Human get(String name) {
        for (Human searchedHuman : peopleStorage) {
            if (searchedHuman.getName().equals(name)) {
                return searchedHuman;
            }
        }
        throw new NoSuchElementException("Вихід за ідекс");
    }
}
