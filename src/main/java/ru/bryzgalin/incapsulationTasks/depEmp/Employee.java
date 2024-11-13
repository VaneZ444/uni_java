package ru.bryzgalin.incapsulationTasks.depEmp;

import lombok.Getter;

@Getter
public class Employee{
    private final String name;
    private Department dep;
    public Employee(String name, Department dep){
        this.name = name;
        setDep(dep);
    }
    public Employee(String name){
        this(name,null);
    }
    public void setDep(Department dep) {
        if(this.dep == dep) return;
        if(this.dep != null) this.dep.removeEmployee(this);
        this.dep = dep;
        if(dep != null) dep.addEmployee(this);
    }
    public void remDep(){
        this.dep = null;
    }

    @Override
    public String toString() {
        if(dep == null) return name+" no dep";
        return getName() + " " + dep.getDepartmentName();
    }
}
