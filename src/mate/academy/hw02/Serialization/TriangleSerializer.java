package mate.academy.hw02.Serialization;

import com.google.gson.*;

import java.lang.reflect.Type;

public class TriangleSerializer implements JsonSerializer<Triangle> {
    @Override
    public JsonElement serialize(Triangle triangle, Type type, JsonSerializationContext jsonSerializationContext) {

        JsonObject result = new JsonObject();
        result.addProperty("name", triangle.getName());

        JsonArray sides = new JsonArray();
        JsonObject side = new JsonObject();
        side.addProperty("Side A", triangle.getSideA());
        sides.add(side);
        side = new JsonObject();
        side.addProperty("Side B", triangle.getSideB());
        sides.add(side);
        side = new JsonObject();
        side.addProperty("Side C", triangle.getSideC());
        sides.add(side);

        result.add("Sides", sides);

        result.addProperty("Square", triangle.getSquare());

        return result;
    }
}
