package ru.bryzgalin.sem1.examPrep.third.transformer;

public interface Writer {
    <T> void write(T item);
}
