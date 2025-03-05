package ru.bryzgalin.sem1.examPrep.third.transformer;

public interface Reader {
    <T> T read(T item);
}
