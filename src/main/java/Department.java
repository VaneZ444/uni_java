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
    private Employee boss;
    private List<Employee> employees = new ArrayList<>();

    public Department(String departmentName, Employee boss, Employee... employees) {
        this.departmentName = departmentName;
        addBoss(boss);
        addEmployee(employees);
    }

    public void addEmployee(Employee... employees) {
        for (Employee emp : employees) {
            if (emp == null) continue;
            if (this.employees.contains(emp) && emp.getDep() == this) continue;
            if (emp.getDep()!=this) emp.setDep(this);
            if (!this.employees.contains(emp)) this.employees.add(emp);
            emp.setDep(this);
        }
    }

    public void addBoss(Employee employee) {
        employee.getDep().removeEmployee(employee);
        addEmployee(employee);
        this.boss = employee;
    }

    public void removeBoss() {
        this.removeEmployee(boss);
        this.boss = null;
    }

    public void removeEmployee(Employee employee) {
        this.employees.remove(employee);
        employee.remDep();
    }

    public Employee getEmployeeByName(String name) {
        for (Employee i : employees) {
            if (i.getName().equals(name)) {
                return i;
            }
        }
        return null;
    }
}