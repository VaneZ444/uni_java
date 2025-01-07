package ru.bryzgalin.examPrep.third.transformer;

public interface Writer {
    <T> void write(T item);
}
