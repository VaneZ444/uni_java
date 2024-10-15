public class Employee {
    String employeeName;
    Department assignedDepartment;
    public Employee(String employeeName, Department assignedDepartment){
        this.employeeName = employeeName;
        this.assignedDepartment = assignedDepartment;
    }
    @Override
    public String toString(){
        return employeeName + ", " + assignedDepartment.departmentName + " (boss : " + assignedDepartment.departmentBoss.employeeName + " )";
    }
}
