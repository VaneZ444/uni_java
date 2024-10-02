public class Student {
    String studentName;
    int[] marks;
    public Student(String studentName, int[] marks){
        this.studentName = studentName;
        this.marks = marks;
    }
    @Override
    public String toString(){
        String reportString = studentName + ": [";
        for (int i = 0; i < marks.length; i++) {
            reportString = reportString + marks[i];
            if (i != marks.length - 1){
                reportString = reportString + ", ";
            }
        }
        reportString = reportString + "]";
        return reportString;
    }
}
