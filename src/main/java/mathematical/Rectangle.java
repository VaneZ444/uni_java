package mathematical;

import lombok.Getter;

@Getter
public class Rectangle extends Figure{
    private int len;
    private int len2;
    public Rectangle(Point a,int len, int len2) {
        super(a);
        this.len = len;
        this.len2 = len2;
    }

    @Override
    public double square() {
        return len*len2;
    }
}
