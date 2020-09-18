package com.lea.day9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author aCheng
 * @create 2020/09/02 下午 2:39
 */
public class DAO<T> {

    private Map<String, T> map;

    public DAO() {
        this.map = new HashMap<>();
    }

    public DAO(Map<String, T> map) {
        this.map = map;
    }

    public void save(String id, T entry) {
        this.map.put(id, entry);
    };

    public T get(String id) {
        return  this.map.get(id);
    };

    public void update(String id, T entry) {
        if (map.containsKey(id)) {
            this.map.put(id, entry);
        }
    }

    public List<T> list() {
        Collection<T> values = map.values();
        ArrayList<T> ts = new ArrayList<>(values.size());
        for (T value : values) {
            ts.add(value);
        }
        return ts;
    }

    public void delete(String id) {
        this.map.remove(id);
    }
}
