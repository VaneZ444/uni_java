package ru.bryzgalin.animals;

import lombok.RequiredArgsConstructor;
import ru.bryzgalin.interfaces.Meowable;

public class DogCat extends Dog implements Meowable {
    private Cat cat;
    DogCat(String name){
        super(name);
        this.cat = new Cat(name);
    }
    @Override
    public void meow() {
        cat.meow();
    }
}
