package ru.bryzgalin.mathematical;
/*
Итератор — это поведенческий паттерн, который предоставляет способ последовательного доступа
 к элементам коллекции, не раскрывая её внутренней структуры.
  Он позволяет обходить элементы коллекции, не зная, как она устроена внутри.
 */
import ru.bryzgalin.interfaces.PolyChainable;

import java.util.ArrayList;
import java.util.List;

public class PolyChain extends PolyLine implements PolyChainable {
    public PolyChain(Point... points) {
        super(points);
    }
    public float len(){
        if (linePoints.size() < 3) return super.len();
        Line tempLine = Line.of(linePoints.getFirst(),linePoints.getLast());
        return super.len() + tempLine.len();
    }
    public List<Point> getPoints(){
        return super.getPoints();
    }

    @Override
    public PolyLine getPolygonalChain() {
        return super.clone();
    }
    public PolyLine toPolyLine(){
        List<Point> tmp= new ArrayList<>(getPoints());
        tmp.add(getPoints().getFirst());
        return new PolyLine(tmp);
    }
    public LineIterator iterator() {
        return new PolyChainIterator();
    }

    private class PolyChainIterator implements LineIterator {
        private int currentIndex = 0;

        @Override
        public Point next() {
            Point point = linePoints.get(currentIndex);
            currentIndex = (currentIndex + 1) % linePoints.size(); // Зацикливание
            return point;
        }

        @Override
        public boolean hasNext() {
            return !linePoints.isEmpty(); // Есть следующая точка, если список не пуст
        }
    }
}
