package ru.bryzgalin.interfaces;

public interface Filter<T> {
    boolean test (T item);
}
