public class JaggedRing extends JaggedLine{
    public JaggedRing(Point... points) {
        super(points);
    }
    public double len(){
        Line tempLine = new Line(linePoints.getFirst(),linePoints.getLast());
        return super.len() + tempLine.lineLen();
    }
}
