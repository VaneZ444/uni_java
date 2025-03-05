package ru.bryzgalin.sem1.animals;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ru.bryzgalin.sem1.interfaces.Meowable;
@RequiredArgsConstructor
public class SmartCat implements Meowable{
    @Getter
    private int counter = 0;
    @NonNull Meowable m;

    @Override
    public void meow() {
        m.meow();
        counter++;
    }
}
