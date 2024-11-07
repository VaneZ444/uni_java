package misc;

import exceptions.IllegalMarkException;

import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Student {
    private String studentName;
    private List<Integer> markList = new ArrayList<>();
    private Predicate<Integer> rule;

    public Student(String studentName, Predicate<Integer> rule, Integer... marks) {
        this.studentName = studentName;
        this.rule = rule;
        addMarks(marks);
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
    }

    public void removeMark(int mark) {
        if (!markList.contains(mark)) throw new RuntimeException("no such mark found");
        markList.remove(markList.indexOf(mark));
    }

    public double round() {
        return markList.stream().mapToDouble(d -> d).average().orElse(0.0);
    }

    @Override
    public String toString() {
        return "misc.Student{" +
                "studentName='" + studentName + '\'' +
                ", marks=" + markList +
                '}';
    }
}
