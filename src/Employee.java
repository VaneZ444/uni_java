public class Employee {
    String employeeName;
    Department assignedDepartment;
    public Employee(String employeeName, Department assignedDepartment){
        this.employeeName = employeeName;
        this.assignedDepartment = assignedDepartment;
    }
    public String introduce(){

        return employeeName + ", " + assignedDepartment.departmentName + " (boss : " + assignedDepartment.departmentBoss.employeeName + " )";
    }
}
