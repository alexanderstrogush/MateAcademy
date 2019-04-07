package hw07.dao;

import hw07.di.Component;
import hw07.model.Human;

import java.util.ArrayList;
import java.util.List;

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
        return null;
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
        return null;
    }
}
