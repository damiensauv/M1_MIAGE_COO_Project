package Util;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class IDMap<T> {
    private Map<Object, WeakReference<T>> map;

    public IDMap() {
        map = new HashMap<Object, WeakReference<T>>();
    }

    public T get(Object id) {
        WeakReference<T> ref = map.get(id);
        if (ref == null)
            return null;

        T obj = ref.get();
        if (obj == null) {
            map.remove(id);
        }
        return obj;
    }

    public void put(Object id, T obj) {
        map.put(id, new WeakReference<T>(obj));
    }

    void delete(Object id) {
        map.remove(id);
    }
}