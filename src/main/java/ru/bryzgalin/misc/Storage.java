package ru.bryzgalin.misc;

public class Storage<T> {
    private final T item;
    private final T alt;

    public Storage(T item, T alt) {
        this.item = item;
        this.alt = alt;
    }

    public T getItem() {
        return item != null ? item : alt;
    }

    public String toString() {
        return "Box[" + item + ']';
    }
}
