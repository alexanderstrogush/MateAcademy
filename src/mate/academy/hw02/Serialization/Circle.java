package mate.academy.hw02.Serialization;

public class Circle extends Figure {
    private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
        setSquare();
    }

    @Override
    public String getName() {
        return super.getName() + "Circle";
    }

    public double getRadius() {
        return radius;
    }

    public void setSquare() {
        square = (Math.pow(radius, 2) * Math.PI);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", square=" + square +
                '}';
    }
}
