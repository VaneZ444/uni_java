package ru.bryzgalin.sem1.misc;

public class Box<T> {
    private T item = null;

    public T takeItem() {
        T tmp = item;
        item = null;
        return tmp;
    }

    public void putItem(T item) {
        if (!isEmpty()) throw new RuntimeException();
        this.item = item;
    }

    public boolean isEmpty() {
        return this.item == null;
    }

    @Override
    public String toString() {
        return "Box[" + item + ']';
    }
}
