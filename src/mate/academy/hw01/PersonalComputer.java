package mate.academy.hw01;

import javax.lang.model.element.PackageElement;
import java.util.Objects;

public class PersonalComputer implements Cloneable{
    private String type;
    private String CPU, GPU;
    private int RAM;
    private int serialNumber;

    public PersonalComputer(String type, int serialNumber, String CPU, String GPU, int RAM) {
        this.type = type;
        this.serialNumber = serialNumber;
        this.CPU = CPU;
        this.GPU = GPU;
        this.RAM = RAM;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getGPU() {
        return GPU;
    }

    public void setGPU(String GPU) {
        this.GPU = GPU;
    }

    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Override
    public String toString() {
        return "{" +
                "type='" + type + '\'' +
                ", serialNumber=" + serialNumber +
                ", CPU='" + CPU + '\'' +
                ", GPU='" + GPU + '\'' +
                ", RAM=" + RAM +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonalComputer that = (PersonalComputer) o;
        return hashCode() == o.hashCode() &&
                RAM == that.RAM &&
                serialNumber == that.serialNumber &&
                Objects.equals(type, that.type) &&
                Objects.equals(CPU, that.CPU) &&
                Objects.equals(GPU, that.GPU);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, CPU, GPU, RAM, serialNumber);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
