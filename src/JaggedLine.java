public class JaggedLine {
    Point[] linePoints;
    public JaggedLine(Point[] linePoints){
        this.linePoints = linePoints;
    }
    public String lineReport(){
        String reportString = "Jagged line [";
        for (int i = 0; i < linePoints.length; i++) {
            reportString = reportString + linePoints[i].cords();
            if (i != linePoints.length - 1){
                reportString = reportString + ", ";
            }
        }
        reportString = reportString + "]";
        return reportString;
    }
}
