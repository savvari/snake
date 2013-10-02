package com.andriod.games.Snake.framework;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sridharavvari
 * Date: 01/10/2013
 * Time: 11:07
 * To change this template use File | Settings | File Templates.
 */
public class Pool<T> {
    public interface PoolObjectFactory<T> {
        public T createObject();
    }

    private final List<T> freeObjects;
    private final PoolObjectFactory<T> factory;
    private final int maxSize;

    public Pool(PoolObjectFactory<T> factory, int maxSize) {
        this.factory = factory;
        this.maxSize = maxSize;
        this.freeObjects = new ArrayList<T>(maxSize);
    }

    public T newObject() {
        T object = null;
        if(freeObjects.size() == 0) {
            object = factory.createObject();
        } else {
            object = freeObjects.remove(freeObjects.size() - 1);
        }

        return object;
    }

    public void free(T object) {
        if(freeObjects.size() < maxSize) {
            freeObjects.add(object);
        }
    }
}
