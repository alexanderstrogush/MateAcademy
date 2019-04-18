package mate.academy.hw02.Serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Service {
    public static void main(String[] args) {
        Group group = Group.createGroup();
        // System.out.println(group);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(Circle.class, new CircleSerializer())
                .registerTypeAdapter(Triangle.class, new TriangleSerializer())
                .registerTypeAdapter(Square.class, new SquareSerializer())
                .create();
        String json = gson.toJson(group);
        System.out.println(json);
    }
}
