import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
abstract public class Worker {
    private String name;
    private Department depo;

    public Worker(String name, Department depo) {
        this.name = name;
        this.depo = depo;
    }

    public Worker(String name) {
        this(name, null);
    }
}
