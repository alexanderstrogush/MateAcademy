package mate.academy.hw02.Serialization;

import com.google.gson.*;

import java.lang.reflect.Type;

// Класс в розробці.

public class GroupSerializer implements JsonSerializer<Group> {
    @Override
    public JsonElement serialize(Group group, Type type, JsonSerializationContext jsonSerializationContext) {

        JsonObject result = new JsonObject();

        result.add(group.getName(), jsonSerializationContext.serialize(group));

        /*JsonArray figures = new JsonArray();
        for (Figure figure: group.getFigures()){
            figures.add(figure.getName(), jsonSerializationContext.serialize(figure));
        }*/

        return result;
    }
}
