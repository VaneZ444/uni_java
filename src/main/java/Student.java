import java.util.List;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class Student {
    String studentName;
    private List<Integer> markList = new ArrayList<>();
    public Student(String studentName, int... mark){
        this.studentName = studentName;
        IntStream.range(0, mark.length).forEach(i -> {
            if (mark[i]>1 &&mark[i]<6) {
                markList.add(mark[i]);
            } else {
                throw new IllegalArgumentException("All mark values should be between 2 and 5");
            }
        });
    }
    public int[] getMarks(){
        int[] a = markList.stream().mapToInt(i -> i).toArray();
        return a;
    }
    public double round(){
        return markList.stream().mapToDouble(d -> d).average().orElse(0.0);
    }
    public boolean isIdeal(){
        return (round() == 5.0);
    }
    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                ", marks=" + markList +
                '}';
    }
}
