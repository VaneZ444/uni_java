package ru.bryzgalin.sem1.misc;

import ru.bryzgalin.sem1.interfaces.StudentAction;

public class SetName implements StudentAction {
    protected String lastName;
    protected Student student;
    public SetName(String studentName, Student student) {
        this.lastName = studentName;
        this.student = student;
    }

    @Override
    public void undo() {
        student.setName(lastName);
        student.history.remove(this);
    }
    @Override
    public String toString() {
        return "old name{"+lastName+'}';
    }
}
