package ru.bryzgalin.sem1.examPrep.templateExamples.structural;
/*
Decorator (Декоратор)
Шаблон, который позволяет динамически добавлять объектам новую функциональность,
 оборачивая их в объекты-декораторы.
  Он используется, когда нужно расширить поведение объекта без изменения его исходного кода.
 */
// 1. Компонент (Component)
interface Coffee {
    String getDescription();
    double getCost();
}

// 2. Конкретный компонент (Concrete Component)
class SimpleCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Простой кофе";
    }

    @Override
    public double getCost() {
        return 200.0; // Базовая стоимость
    }
}

// 3. Декоратор (Decorator)
abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost();
    }
}

// 4. Конкретный декоратор (Concrete Decorator)
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", молоко";
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 50.0; // Добавляем стоимость молока
    }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", сахар";
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 20.0; // Добавляем стоимость сахара
    }
}

// 5. Клиентский код
public class DecoratorTest {
    public static void main(String[] args) {
        // Создаем базовый кофе
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription() + " = рублей " + coffee.getCost());

        // Добавляем молоко
        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getDescription() + " = рублей " + coffee.getCost());

        // Добавляем сахар
        coffee = new SugarDecorator(coffee);
        System.out.println(coffee.getDescription() + " = рублей " + coffee.getCost());
    }
}