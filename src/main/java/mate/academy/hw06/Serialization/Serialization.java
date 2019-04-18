package mate.academy.hw06.Serialization;

import java.io.*;
import java.util.Arrays;

public class Serialization {
    public static void main(String[] args) {
        Animal[] animalBeforeSerialization = createTestAnimalArray();
        System.out.println("Animals before serialization : " + Arrays.toString(animalBeforeSerialization));
        byte[] animalsByte = serializeAnimalArray(animalBeforeSerialization);
        Animal[] animalsAfterSerialization = deserializeAnimalArray(animalsByte);
        System.out.println("Animals after serialization : " + Arrays.toString(animalsAfterSerialization));
    }

    private static Animal[] createTestAnimalArray() {
        return new Animal[]{new Animal("Cat"),
                new Animal("Dog"),
                new Animal("Elephant"),
                new Animal("Cock"),
                new Animal("Bull"),
                new Animal("Ant"),
                new Animal("Tentacles"),
                new Animal("Worm")};
    }

    public static byte[] serializeAnimalArray(Animal[] animals) {
        Animal[] animalsBeforeSerialization = animals;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);) {
            objectOutputStream.writeInt(animalsBeforeSerialization.length);
            for (int i = 0; i < animalsBeforeSerialization.length; i++) {
                objectOutputStream.writeObject(animalsBeforeSerialization[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
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
