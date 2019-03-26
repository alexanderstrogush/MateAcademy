package mate.academy.hw02.Serialization;

import com.google.gson.*;

import java.lang.reflect.Type;

public class CircleSerializer implements JsonSerializer<Circle> {
    @Override
    public JsonElement serialize(Circle circle, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject result = new JsonObject();

        result.addProperty("name", circle.getName());

        JsonObject properties = new JsonObject();
        properties.addProperty("Radius", circle.getRadius());
        // result.addProperty("radius", circle.getRadius());
        // result.addProperty("square", circle.getSquare());

        result.add("Properties", properties);

        result.addProperty("Square", circle.getSquare());

        return result;
    }
}
