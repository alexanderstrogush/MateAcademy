package model;

import java.io.Serializable;
import java.util.Objects;

public class Good implements Serializable {

    private long goodId;
    private String name;
    private String description;
    private double price;

    public Good(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Good(long goodId, String name, String description, double price) {
        this.goodId = goodId;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public long getGoodId() {
        return goodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Good good = (Good) o;
        return goodId == good.goodId &&
                Double.compare(good.price, price) == 0 &&
                name.equals(good.name) &&
                Objects.equals(description, good.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodId, name, description, price);
    }

    @Override
    public String toString() {
        return "Good{" +
                "goodId=" + goodId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
