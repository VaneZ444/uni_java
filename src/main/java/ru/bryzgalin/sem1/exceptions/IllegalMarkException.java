package ru.bryzgalin.sem1.exceptions;

public class IllegalMarkException extends IllegalArgumentException {
    private int IllegalMark;

    public IllegalMarkException(String message) {
        super(message);
    }

    public IllegalMarkException(int x) {
        super(x + " cannot be a mark");
        this.IllegalMark = x;
    }

    public int getIllegalMark() {
        return IllegalMark;
    }
}
