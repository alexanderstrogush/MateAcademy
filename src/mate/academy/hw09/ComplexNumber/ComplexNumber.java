package mate.academy.hw09.ComplexNumber;

public final class ComplexNumber {

    private final double real;
    private final double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if ((obj == null) || !(obj instanceof ComplexNumber)) {
            return false;
        }
        ComplexNumber equalsTest = (ComplexNumber) obj;

        return real == equalsTest.real &
                imaginary == equalsTest.imaginary;
    }

    public int hashCode() {
        int result = 26;
        long longBits = Double.doubleToLongBits(real);
        result = 7 * result + (int) (longBits - (longBits >>> 32));
        longBits = Double.doubleToLongBits(imaginary);
        result = 7 * result + (int) (longBits - (longBits >>> 32));

        return result;
    }
}
