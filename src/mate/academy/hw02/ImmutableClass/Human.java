package mate.academy.hw02.ImmutableClass;

// Immutable class
public final class Human {
    final private String name, bith;
    final private int passport;

    public Human(String name, String birth, int passport) {
        this.name = name;
        this.bith = birth;
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public String getBith() {
        return bith;
    }

    public int getPassport() {
        return passport;
    }

    @Override
    public String toString() {
        return name + "{" +
                ", bith='" + bith + '\'' +
                ", passport=" + passport +
                '}';
    }
}
