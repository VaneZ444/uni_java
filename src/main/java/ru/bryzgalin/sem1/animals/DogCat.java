package ru.bryzgalin.sem1.animals;
import ru.bryzgalin.sem1.interfaces.Meowable;

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
