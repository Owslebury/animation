package com.example.animation.object;

import java.util.ArrayList;
import java.util.List;

public class ObjectList {
    private static ObjectList instance;
    private List<Object> objectList;

    private ObjectList() {
        // Initialize the objectList as an ArrayList
        objectList = new ArrayList<>();
    }

    public static synchronized ObjectList getInstance() {
        if (instance == null) {
            instance = new ObjectList();
        }
        return instance;
    }

    public List<Object> getObjectList() {
        return objectList;
    }

    // Add methods to manipulate the objectList as needed
    public void addObject(Object obj) {
        objectList.add(obj);
    }

    public void removeObject(Object obj) {
        objectList.remove(obj);
    }

    // Add other methods as needed

}
