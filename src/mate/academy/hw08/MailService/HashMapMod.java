package mate.academy.hw08.MailService;

import java.util.Collections;
import java.util.HashMap;

public class HashMapMod<K, V> extends HashMap<K, V> {

    @Override
    public V get(Object key) {
        if (this.containsKey(key)) {
            return super.get(key);
        }
        return (V) Collections.emptyList();
    }
}
