package mate.academy.hw02.Classes;

// Anonymous Class
public class Anonymous {
    public static void main(String[] args) {
        Cheese cheese = new Cheese() {
            @Override
            public void getCheese() {
                System.out.println("I took some cheese.");
            }
        };
        cheese.getCheese();
    }
}

class Cheese {
    public void getCheese() {
        System.out.println("Cheese)))");
    }
}
