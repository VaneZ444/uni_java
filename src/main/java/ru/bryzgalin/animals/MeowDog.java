package ru.bryzgalin.animals;

import lombok.RequiredArgsConstructor;
import ru.bryzgalin.interfaces.Meowable;
@RequiredArgsConstructor
public class MeowDog implements Meowable {
    Dog dog;
    Cat cat;

    @Override
    public void meow() {
        dog.woof();
    }
}
