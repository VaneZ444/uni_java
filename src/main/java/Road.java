import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class Road {
    private City roadTo;
    private City roadFrom;
    private int length;
    public Road(City roadFrom, City roadTo, int length){
        this.roadFrom = roadFrom;
        this.roadTo = roadTo;
        if(!lengthIsValid(length)) throw new IllegalArgumentException("Invalid road length");
        this.length = length;
    }
    private boolean lengthIsValid(int length){
        return length>0;
    }
    public boolean isEqualRoad(Road r){
        return (this.roadTo.equals(r.roadTo)&&this.roadFrom.equals(r.roadFrom));
    }
}
