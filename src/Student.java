import java.util.List;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class Student {
    String studentName;
    List<Integer> markList = new ArrayList<>();
    public Student(String studentName, int... mark){
        this.studentName = studentName;
        IntStream.range(0, mark.length).forEach(i -> {
            markList.add(mark[i]);
        });
    }
    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                ", marks=" + markList +
                '}';
    }
}