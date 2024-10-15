import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
@Setter
public class Department {
    private String departmentName;
    private Boss boss;
    private List<Worker> workers = new ArrayList<>();

    public Department(String departmentName, Employee boss, Worker... workers) {
        this.departmentName = departmentName;
        addBoss(boss);
        addEmployee(workers);
    }

    public void addEmployee(Worker... newMembers) {
        for (Worker n : newMembers) {
            if (this.workers.contains(n))
                throw new IllegalArgumentException("worker " + n + "is already in department");
            this.workers.add(n);
            n.setDepo(this);
        }
    }

    public void addBoss(Employee employee) {
        if (this.boss != null) {
            throw new RuntimeException("You must remove previous boss before adding next one");
        }
        employee.getDepo().removeEmployee(employee);
        Boss boss = new Boss(employee);
        addEmployee(new Boss(employee));
        this.boss = boss;
        this.boss.setDepoInPower(this);
    }

    public void removeBoss(Boss boss) {
        if (this.boss == null) {
            throw new RuntimeException("You must have a boss if you want to remove him");
        }
        this.boss.setDepoInPower(null);
        boss.getDepo().removeEmployee(boss);
        addEmployee(new Employee(boss));
        this.boss = null;
    }

    public void removeEmployee(Employee employee) {
        this.workers.remove(employee);
        employee.setDepo(null);
    }

    public Worker getWorkerByName(String name) {
        for (Worker i : workers) {
            if (i.getName().equals(name)) {
                return i;
            }
        }
        return null;
    }
}