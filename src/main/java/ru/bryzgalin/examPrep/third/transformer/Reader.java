package ru.bryzgalin.examPrep.third.transformer;

public interface Reader {
    <T> T read(T item);
}
