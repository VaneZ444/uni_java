package mathematical;

public class JaggedRing extends JaggedLine{
    public JaggedRing(Point... points) {
        super(points);
    }
    public double len(){
        if (linePoints.size() < 3) return super.len();
        Line tempLine = new Line(linePoints.getFirst(),linePoints.getLast());
        return super.len() + tempLine.len();
    }
}
