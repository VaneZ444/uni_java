package ru.bryzgalin.sem1.examPrep.templateExamples.generating;
/*
Factory Method (Фабричный метод)
Используется, когда нужно создавать объекты одного типа,
 но с разными вариациями (например, разные виды животных).
 Метод в фабрике один, и продукт тоже один, здесь это Animal
*/
// Абстрактный продукт
interface Animal {
    void speak();
}

// Конкретные продукты
class Dog implements Animal {
    public void speak() {
        System.out.println("Woof!");
    }
}

class Cat implements Animal {
    public void speak() {
        System.out.println("Meow!");
    }
}

// Абстрактная фабрика
abstract class AnimalFactory {
    public abstract Animal createAnimal();
}

// Конкретные фабрики
class DogFactory extends AnimalFactory {
    public Animal createAnimal() {
        return new Dog();
    }
}

class CatFactory extends AnimalFactory {
    public Animal createAnimal() {
        return new Cat();
    }
}

// Пример использования
public class FactoryMethodTest {
    public static void main(String[] args) {
        AnimalFactory dogFactory = new DogFactory();
        Animal dog = dogFactory.createAnimal();
        dog.speak(); // Woof!

        AnimalFactory catFactory = new CatFactory();
        Animal cat = catFactory.createAnimal();
        cat.speak(); // Meow!
    }
}