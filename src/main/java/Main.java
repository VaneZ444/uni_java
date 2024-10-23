public class Main {
    public static void main(String[] args) {
        testEmp();
        testDep();
    }

    public static void testEmp() {
        Employee emp = new Employee("Ivanov");
        Department dep1 = new Department("IT");
        Department dep2 = new Department("Acc");

        System.out.println("\n1 evetything is empty");
        System.out.println(emp);
        System.out.println(dep1);
        System.out.println(dep2);

        System.out.println("\n2 Ivanov to It");
        emp.setDep(dep1);
        System.out.println(emp);
        System.out.println(dep1);
        System.out.println(dep2);

        System.out.println("\n3 Ivanov to acc");
        emp.setDep(dep2);
        System.out.println(emp);
        System.out.println(dep1);
        System.out.println(dep2);

        System.out.println("\n4 Ivanov from acc to it");
        emp.setDep(dep1);
        System.out.println(emp);
        System.out.println(dep1);
        System.out.println(dep2);
    }

    public static void testDep(){
        Employee emp = new Employee("Ivanov");
        Department dep1 = new Department("IT");
        Department dep2 = new Department("Acc");

        System.out.println("\n1 evetything is empty");
        System.out.println(emp);
        System.out.println(dep1);
        System.out.println(dep2);

        System.out.println("\n2 Ivanov to It");
        dep1.addEmployee(emp);
        System.out.println(emp);
        System.out.println(dep1);
        System.out.println(dep2);

        System.out.println("\n3 Ivanov to acc");
        dep2.addEmployee(emp);
        System.out.println(emp);
        System.out.println(dep1);
        System.out.println(dep2);

        System.out.println("\n4 Ivanov from acc to it");
        dep1.addBoss(emp);
        System.out.println(emp);
        System.out.println(dep1);
        System.out.println(dep2);

        System.out.println("\n4 ivanov removed everywhere");
        dep1.removeEmployee(emp);
        System.out.println(emp);
        System.out.println(dep1);
        System.out.println(dep2);
    }

}