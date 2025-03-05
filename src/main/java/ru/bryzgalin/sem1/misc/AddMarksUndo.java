package ru.bryzgalin.sem1.misc;

import ru.bryzgalin.sem1.interfaces.StudentAction;

public class AddMarksUndo implements StudentAction {
    protected int markCount;
    protected Student student;

    public AddMarksUndo(int markCount, Student student){
        this.markCount = markCount;
        this.student = student;
    }

    public void undo(){
        for (int i = 0; i < markCount; i++) {
            student.markList.removeLast();
        }
        student.history.remove(this);
    }

    @Override
    public String toString() {
        return "Marks{" + markCount +'}';
    }
}
