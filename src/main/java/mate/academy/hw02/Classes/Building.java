package mate.academy.hw02.Classes;

// Static Nested Class
public abstract class Building {

    private String name;
    private String address;
    private String type;

    public Building(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static class House extends Building {
        public House(String name, String adress) {
            super(name, adress);
            this.setType("House");
        }

        @Override
        public String toString() {
            return "House{" +
                    "name='" + getName() + '\'' +
                    ", address='" + getAddress() + '\'' +
                    ", type='" + getType() + '\'' +
                    '}';
        }
    }

    public static class Office extends Building {
        public Office(String name, String address) {
            super(name, address);
            this.setType("Office");
        }

        @Override
        public String toString() {
            return "Office{" +
                    "name='" + getName() + '\'' +
                    ", address='" + getAddress() + '\'' +
                    ", type='" + getType() + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        Building.Office myOffice = new Building.Office("Strog Corp", "Pacichna, 143");
        System.out.println(myOffice);

        Building.House myHouse = new Building.House("My home", "Honey Cave, 65");
        System.out.println(myHouse);
    }
}
