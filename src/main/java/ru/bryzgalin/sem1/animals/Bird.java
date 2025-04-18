package ru.bryzgalin.sem1.animals;

import ru.bryzgalin.annotations.Invoke;

public abstract class Bird {
    private String name;
    public Bird(String name){
        this.name = name;
    }
    public abstract String sing();

    @Override
    public String toString() {
        return name + " does" + sing();
    }
}
