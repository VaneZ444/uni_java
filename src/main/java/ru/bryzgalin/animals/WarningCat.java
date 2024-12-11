package ru.bryzgalin.animals;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ru.bryzgalin.interfaces.Meowable;
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
