package mate.academy.hw02.Classes;

// Local Class
public class Hello {
    public static void main(String[] args) {
        sayHello("Alex");
    }

    private static void sayHello(String name) {
        class Human {
            private String name;

            public Human(String name) {
                this.name = name;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            void sayHello() {
                System.out.println(name + " say you \"Hello!\"");
            }
        }

        Human alex = new Human(name);
        alex.sayHello();
    }
}
