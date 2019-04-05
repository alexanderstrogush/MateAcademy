package mate.academy.hw06.Serialization;

import java.io.*;

public class Serialization {
    public static void main(String[] args) {
        Animal[] animalsBeforeSerialization = {new Animal("Cat"),
                new Animal("Dog"),
                new Animal("Elephant"),
                new Animal("Cock"),
                new Animal("Bull"),
                new Animal("Ant"),
                new Animal("Tentecles"),
                new Animal("Worm")};
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);) {
            objectOutputStream.writeInt(animalsBeforeSerialization.length);
            for (int i = 0; i < animalsBeforeSerialization.length; i++) {
                objectOutputStream.writeObject(animalsBeforeSerialization[i]);
            }
            Animal[] animalsAfterSerialization = deserializeAnimalArray(byteArrayOutputStream.toByteArray());
            for (Animal animal : animalsAfterSerialization) {
                System.out.println(animal);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Animal[] deserializeAnimalArray(byte[] data) throws IllegalArgumentException {
        Animal[] result;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(data));) {
            int length = objectInputStream.readInt();
            result = new Animal[length];
            for (int i = 0; i < length; i++) {
                result[i] = (Animal) objectInputStream.readObject();
            }
        } catch (IOException | ClassNotFoundException | ClassCastException e) { // catch(Exception e) {
            throw new IllegalArgumentException();
        }
        return result;
    }
}
