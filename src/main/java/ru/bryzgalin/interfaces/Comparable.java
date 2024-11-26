package ru.bryzgalin.interfaces;

public interface Comparable <T extends Comparable> {
    int compare(T object);
}
