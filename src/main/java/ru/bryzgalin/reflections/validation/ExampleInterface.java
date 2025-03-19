package ru.bryzgalin.reflections.validation;

import ru.bryzgalin.annotations.Cache;
import ru.bryzgalin.annotations.Mutator;

public interface ExampleInterface {
    @Cache
    public int getValue();

    @Mutator
    public void setValue(int value);
}
