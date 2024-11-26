package ru.bryzgalin.misc;

import ru.bryzgalin.exceptions.IllegalMarkException;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Student implements Comparable<Student>{
    protected String studentName;
    protected List<Integer> markList = new ArrayList<>();
    private Predicate<Integer> rule;
    public List<StudentAction> history = new ArrayList<>();
    public Student(String studentName, Predicate<Integer> rule, Integer... marks) {
        setName(studentName);
        this.rule = rule;
        addMarks(marks);
    }
    public void setName(String studentName){
        this.studentName = studentName;
        history.add(new SetName(this.studentName,this));
    }
    public Student(String studentName, Integer... marks) {
        this(studentName, mark -> mark >= 2 && mark <= 5, marks);
    }

    public ArrayList<Integer> getMarks() {
        return new ArrayList<Integer>(this.markList);
    }

    public void addMarks(Integer... marks) {
        IntStream.range(0, marks.length).forEach(i -> {
            if (!rule.test(marks[i])) throw new IllegalMarkException(marks[i]);
            markList.add(marks[i]);
        });
        history.add(new AddMarksUndo(marks.length,this));
    }

    public void removeMark(int mark) {
        if (!markList.contains(mark)) throw new RuntimeException("no such mark found");
        markList.remove(markList.indexOf(mark));
    }

    public double round() {
        return markList.stream().mapToDouble(d -> d).average().orElse(0.0);
    }
    public void undo(){
        history.getLast().undo();
        history.removeLast();
    }
    @Override
    public String toString() {
        return "misc.Student{" +
                "studentName='" + studentName + '\'' +
                ", marks=" + markList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return (Objects.equals(studentName, student.studentName))&&(round() == student.round());
    }
    @Override
    public int hashCode() {
        return Objects.hash(studentName, round());
    }

    @Override
    public int compareTo(Student o) {
        return Double.compare(this.round(), o.round());
    }
}