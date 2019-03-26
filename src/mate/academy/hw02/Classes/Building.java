package mate.academy.hw02.Classes;

// Static Nested Class
public abstract class Building {

    private String name;
    private String adress;
    private String type;

    public Building(String name, String adress) {
        this.name = name;
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
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
    }

    public static class Office extends Building {
        public Office(String name, String adress) {
            super(name, adress);
            this.setType("Office");
        }
    }
}
