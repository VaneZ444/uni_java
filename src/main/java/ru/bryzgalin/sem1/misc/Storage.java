package ru.bryzgalin.sem1.misc;

public class Storage<T> {
    private final T item;
    final static Storage nullStorage = new Storage<>(null);
    private Storage(T item) {
        this.item = item;
    }

    public T getItem(T alt) {
        return item != null ? item : alt;
    }

    public String toString() {
        return "Box[" + item + ']';
    }
    public static <V> Storage<V> of(V item){
        if(item == null) empty();
        return new Storage<>(item);
    }
    public static Storage empty(){
        return nullStorage;
    }
}
