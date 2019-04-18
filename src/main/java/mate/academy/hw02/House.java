package mate.academy.hw02;

// Pattern Builder
public class House {

    private String address;
    private int floors;
    private int windows;
    private int doors;
    private boolean hasYard;
    private boolean hasPool;

    private House(HomeBuilder homeBuilder) {
        this.address = homeBuilder.address;
        this.floors = homeBuilder.floors;
        this.windows = homeBuilder.windows;
        this.doors = homeBuilder.doors;
        this.hasYard = homeBuilder.hasYard;
        this.hasPool = homeBuilder.hasPool;
    }

    public static class HomeBuilder {

        private String address;
        private int floors;
        private int windows;
        private int doors;
        private boolean hasYard;
        private boolean hasPool;

        public HomeBuilder(String address) {
            this.address = address;
        }

        public HomeBuilder howManyFloors(int floors) {
            this.floors = floors;
            return this;
        }

        public HomeBuilder howManyWindows(int windows) {
            this.windows = windows;
            return this;
        }

        public HomeBuilder howManyDoors(int doors) {
            this.doors = doors;
            return this;
        }

        public HomeBuilder hasYard(boolean yard) {
            this.hasYard = yard;
            return this;
        }

        public HomeBuilder hasPool(boolean pool) {
            this.hasPool = true;
            return this;
        }

        public House build() {
            return new House(this);
        }
    }

    @Override
    public String toString() {
        return "House{" +
                "address='" + address + '\'' +
                ", floors=" + floors +
                ", windows=" + windows +
                ", doors=" + doors +
                ", hasYard=" + hasYard +
                ", hasPool=" + hasPool +
                '}';
    }

    public static void main(String[] args) {
        House house = new House.HomeBuilder("Lychakivska, 142")
                .howManyFloors(2)
                .howManyWindows(6)
                .howManyDoors(4)
                .hasYard(true)
                .hasPool(true)
                .build();

        System.out.println(house);
    }
}
