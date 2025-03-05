package ru.bryzgalin.sem1.animals;

import lombok.RequiredArgsConstructor;
import ru.bryzgalin.sem1.interfaces.Meowable;
@RequiredArgsConstructor
public class MeowDog implements Meowable {
    Dog dog;
    Cat cat;

    @Override
    public void meow() {
        dog.woof();
    }
}
