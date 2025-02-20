package ru.bryzgalin.examPrep.templateExamples.behavioral;
/*
Visitor (Посетитель)
Используется для упрощения операций над группировками связанных объектов.
 */
interface Visitor {
    void visit(SportCar sportCar);
    void visit(VisitorEngine engine);
    void visit(VisitorWhell whell);
}
interface VisitorCar {
    void accept(Visitor visitor);
}
class VisitorEngine implements VisitorCar {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
class VisitorWhell implements VisitorCar {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
class SportCar implements VisitorCar {
    VisitorCar[] cars;
    public SportCar(){
        cars = new VisitorCar[]{new VisitorEngine(), new VisitorWhell()};
    }
    public void accept(Visitor visitor) {
        for (VisitorCar car : cars) {
            car.accept(visitor);
        }
        visitor.visit(this);
    }
}
class  CarVisitor implements Visitor {
    public void visit(SportCar computer) {
        print("car");
    }
    public void visit(VisitorEngine engine) {
        print("engine");
    }
    public void visit(VisitorWhell whell) {
        print("whell");
    }
    private void print(String string) {
        System.out.println(string);
    }
}

public class VisitorTest {
    public static void main(String[] args) {
        VisitorCar computer = new SportCar();
        computer.accept(new CarVisitor());
    }
}