import java.util.List;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class Student {
    private String studentName;
    private List<Integer> markList = new ArrayList<>();
    public Student(String studentName, Integer... marks){
        this.studentName = studentName;
        addMarks(marks);
    }
    public ArrayList<Integer> getMarks(){
        return new ArrayList<Integer>(this.markList);
    }
    public void addMarks(Integer... marks){
        IntStream.range(0, marks.length).forEach(i -> {
            if (marks[i]>1 &&marks[i]<6) {
                markList.add(marks[i]);
            } else {
                throw new IllegalArgumentException("All mark values should be between 2 and 5");
            }
        });
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
