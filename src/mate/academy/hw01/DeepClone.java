package mate.academy.hw01;

public class DeepClone {
    public static void main(String[] args) throws CloneNotSupportedException {
        PersonalComputer laptop = new PersonalComputer("Laptop", 1231244, "I5-8600K", "GTX 2080 TI", 16);
        Human alex = new Human("Alex", 17, 'M', 456353, laptop);
        System.out.println(alex);

        Human ivan = (Human) alex.clone();
        System.out.println(ivan);

        System.out.println(alex.equals(ivan));

        ivan.setName("Ivan");
        alex.setAge(21);
        ivan.getPc().setCPU("Celeron");

        System.out.println(alex);
        System.out.println(ivan);
    }
}
