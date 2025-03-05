package ru.bryzgalin.sem1.examPrep.templateExamples.generating;
/*
Prototype
Шаблон, который позволяет создавать новые объекты путем
копирования существующих (прототипов), вместо
 создания объектов с нуля через конструкторы.
В большинстве случаев лучше всего просто implements Cloneable,
 иногда прийдется продумать глубокое копирование
 */
class ComplicatedObject implements Cloneable {
    private Type type;
    public enum Type {
        ONE, TWO
    }
    public ComplicatedObject clone() {
        try {
            return (ComplicatedObject) super.clone(); // Используем super.clone()
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Клонирование не поддерживается", e);
        }
    }
    public void setType(Type type) {
        this.type = type;
    }
}

public class PrototypeTest {
    public static void main(String[] args) {
        ComplicatedObject prototype = new ComplicatedObject();
        ComplicatedObject clone = prototype.clone();
        clone.setType(ComplicatedObject.Type.ONE);
    }
}