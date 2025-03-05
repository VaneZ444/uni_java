package ru.bryzgalin.sem1.examPrep.templateExamples.behavioral;
/*
Template Method (Шаблонный метод)
Позволяет определить основу алгоритма и позволяющий подклассам
 переопределять определенные шаги алгоритма, не изменяя его структуру в целом.
 */
// 1. Абстрактный класс (Abstract Class)
abstract class Beverage {
    // Шаблонный метод вот он во всей красе
    public final void prepareBeverage() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    // Шаги алгоритма
    protected void boilWater() {
        System.out.println("Кипятим воду");
    }

    protected void pourInCup() {
        System.out.println("Наливаем в чашку");
    }

    // Абстрактные методы, которые должны быть реализованы подклассами
    protected abstract void brew();
    protected abstract void addCondiments();
}

// 2. Конкретный класс (Concrete Class)
class Tea extends Beverage {
    @Override
    protected void brew() {
        System.out.println("Завариваем чай");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Добавляем лимон");
    }
}

class Coffee extends Beverage {
    @Override
    protected void brew() {
        System.out.println("Завариваем кофе");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Добавляем сахар и молоко");
    }
}

// 3. Клиентский код
public class TemplateMethodTest {
    public static void main(String[] args) {
        Beverage tea = new Tea();
        tea.prepareBeverage();

        System.out.println(tea);

        Beverage coffee = new Coffee();
        coffee.prepareBeverage();

        System.out.println(coffee);
    }
}