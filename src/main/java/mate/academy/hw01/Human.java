package mate.academy.hw01;

import java.util.Objects;

public class Human implements Cloneable {
    private String name;
    private int age;
    private char sex;
    private int passport;
    private PersonalComputer pc;

    public Human(String name, int age, char sex, int passport, PersonalComputer pc) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.passport = passport;
        this.pc = pc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getPassport() {
        return passport;
    }

    public void setPassport(int passport) {
        this.passport = passport;
    }

    public PersonalComputer getPc() {
        return pc;
    }

    public void setPc(PersonalComputer pc) {
        this.pc = pc;
    }

    @Override
    public String toString() {
        return name + "{" +
                ", age=" + age +
                ", sex=" + sex +
                ", passport=" + passport +
                ", pc=" + pc +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return hashCode() == o.hashCode() &&
                age == human.age &&
                sex == human.sex &&
                passport == human.passport &&
                name.equals(human.name) &&
                pc.equals(((Human) o).pc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex, passport, pc);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Human cloned = (Human) super.clone();

        cloned.setPc((PersonalComputer) cloned.getPc().clone());

        return cloned;
    }
}
