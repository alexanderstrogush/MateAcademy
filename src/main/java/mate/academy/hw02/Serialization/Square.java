package mate.academy.hw02.Serialization;

public class Square extends Figure {
    private double hight, width;

    public Square() {
    }

    public Square(double hight, double width) {
        this.hight = hight;
        this.width = width;
        setSquare();
    }

    @Override
    public String getName() {
        return super.getName() + "Square";
    }

    public double getHight() {
        return hight;
    }

    public void setHight(double hight) {
        this.hight = hight;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setSquare() {
        square = hight * width;
    }

    @Override
    public String toString() {
        return "Square{" +
                "hight=" + hight +
                ", width=" + width +
                ", square=" + square +
                '}';
    }
}
