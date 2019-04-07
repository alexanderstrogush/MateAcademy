package hw07.dao;

import hw07.model.Human;

public interface HumanDao {

    void save(Human human);

    Human get();

    Human get(String name);

    Human get(int index);
}
