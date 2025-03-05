package ru.bryzgalin.sem1.examPrep.templateExamples.structural;
/*
Facade (Фасад)
Скрывает сложную систему классов приводя все вызовы к одному объекту.
 Помещает вызов нескольких сложных объектов в один объект.
 */
interface CarForTest {
    void start();
    void stop();
}
class Key implements CarForTest {
    public void start() {
        System.out.println("Вставить ключи");
    }
    public void stop() {
        System.out.println("Вытянуть ключи");
    }
}
class Engine implements CarForTest {
    public void start() {
        System.out.println("Запустить двигатель");
    }
    public void stop() {
        System.out.println("Остановить двигатель");
    }
}
class Facade {
    private Key key;
    private Engine engine;
    public Facade() {
        key = new Key();
        engine = new Engine();
    }
    public void startCar() {
        key.start();
        engine.start();
    }
    public void stoptCar() {
        key.stop();
        engine.stop();
    }
}

public class FacadeTest {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.startCar();
        System.out.println();
        facade.stoptCar();
    }
}