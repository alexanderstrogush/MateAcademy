package mate.academy.hw02.ImmutableClass;

// Immutable class
public final class Human {

    final private String name;
    final private String birthday;
    final private int passport;

    public Human(String name, String birthday, int passport) {
        this.name = name;
        this.birthday = birthday;
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public int getPassport() {
        return passport;
    }

    @Override
    public String toString() {
        return name + "{" +
                ", birthday='" + birthday + '\'' +
                ", passport=" + passport +
                '}';
    }
}
