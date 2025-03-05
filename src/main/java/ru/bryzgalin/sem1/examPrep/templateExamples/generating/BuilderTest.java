package ru.bryzgalin.sem1.examPrep.templateExamples.generating;

import lombok.Getter;

/*
Builder (Строитель)
Полезно когда заранее известны все варианты, и требуется создавать разносортные обьекты из заранее известных параметров
 */
@Getter
class Employee {
    //поля для всех возможных параметров
    private String name;
    private String company;
    private boolean hasCar;
    private boolean hasBike;
    //ПРИВАТНЫЙ конструктор
    private Employee(EmployeeBuilder employeeBuilder) {
        name = employeeBuilder.name;
        company = employeeBuilder.company;
        hasCar = employeeBuilder.hasCar;
        hasBike = employeeBuilder.hasBike;
    }

    //сам билдер в виде вложенного статического класса
    public static class EmployeeBuilder {
        //поля для всех возможных параметров
        private String name;
        private String company;
        private boolean hasCar;
        private boolean hasBike;


        public EmployeeBuilder(String name, String company) {
            this.name = name;
            this.company = company;
        }


        public EmployeeBuilder setHasCar(boolean hasCar) {
            this.hasCar = hasCar;
            return this;
        }

        public EmployeeBuilder setHasBike(boolean hasBike) {
            this.hasBike = hasBike;
            return this;
        }


        public Employee build() {
            return new Employee(this);
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", hasCar=" + hasCar +
                ", hasBike=" + hasBike +
                '}';
    }
}

public class BuilderTest {
    public static void main(String[] args) {
        //new Employee.EmployeeBuilder - обращение именно к билдеру
        //build уже возвращает employee
        Employee employee = new Employee.EmployeeBuilder("Vikram", "ABC").setHasBike(false).setHasBike(true).build();
        System.out.println(employee);
    }
}