public class Employee extends Worker {
    public Employee(String name, Department depo) {
        super(name, depo);
    }

    public Employee(Boss boss) {
        super(boss.getName(), boss.getDepo());
    }
}
