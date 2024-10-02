
public class Department {
    String departmentName;
    Employee departmentBoss;
    Employee[] employees;
    int empAmount = 0;
    public Department(String departmentName, int maxEmployees){
        this.departmentName = departmentName;
        employees = new Employee[maxEmployees];
    }
    public void addEmployee(Employee newMember){
        employees[empAmount] = newMember;
        newMember.assignedDepartment = this;
        empAmount++;
    }
    public void addBoss(Employee boss){
        departmentBoss = boss;
    }
    public Employee getEmployeeByName(String name){
        for (int i = 0; i < empAmount; i++) {
            if (employees[i].employeeName.equals(name)) {
                return employees[i];
            }
        }
        return null;
        //на случай если нужно найти кого то в любом случае
        //int randEmployeeIndex = (int) (Math.random() * empAmount);
        //return employees[randEmployeeIndex];
    @Override
    public String toString(){
        String currStaffResponse = departmentName + " current employees : ";
        for (int i = 0; i < empAmount; i++) {
            currStaffResponse += employees[i].employeeName;
            if(i != empAmount -1) currStaffResponse = currStaffResponse + ", ";
        }
        return currStaffResponse;
    }
}
