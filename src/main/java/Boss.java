import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Boss extends Employee {
    private Department depoInPower;

    public Boss(String name, Department depo) {
        super(name, depo);
    }

    public Boss(Employee employee) {
        super(employee.getName(), employee.getDepo());
    }

    public Boss(Employee employee, Department depoInPower) {
        super(employee.getName(), employee.getDepo());
        this.depoInPower = depoInPower;
    }
}
