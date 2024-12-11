package ru.bryzgalin.animals;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ru.bryzgalin.interfaces.Meowable;
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
