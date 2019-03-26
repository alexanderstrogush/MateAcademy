package mate.academy.hw02.Serialization;

import com.google.gson.*;

import java.lang.reflect.Type;

public class SquareSerializer implements JsonSerializer<Square> {
    @Override
    public JsonElement serialize(Square square, Type type, JsonSerializationContext jsonSerializationContext) {

        JsonObject result = new JsonObject();

        JsonArray sides = new JsonArray();
        JsonObject side = new JsonObject();
        side.addProperty("Side A", square.getHight());
        sides.add(side);
        side = new JsonObject();
        side.addProperty("Side B", square.getWidth());
        sides.add(side);

        result.add("Sides", sides);
        result.addProperty("Square", square.getSquare());

        return result;
    }
}
