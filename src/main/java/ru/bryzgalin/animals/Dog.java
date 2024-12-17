package ru.bryzgalin.animals;

import lombok.Getter;

@Getter
public class Dog {
    private String name;

    public Dog(String name) {
        this.name = name;
    }
    public void woof(){
        System.out.println("woof");
    }
}
