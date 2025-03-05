package ru.bryzgalin.sem1.animals;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ru.bryzgalin.sem1.interfaces.Meowable;
@RequiredArgsConstructor
public class WarningCat implements Meowable {
    @NonNull
    Meowable m;
    @Override
    public void meow() {
        System.out.println("Achtung!");
        m.meow();
    }
}
