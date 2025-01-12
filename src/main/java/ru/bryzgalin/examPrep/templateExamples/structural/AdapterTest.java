package ru.bryzgalin.examPrep.templateExamples.structural;
/*
Adapter
Конвертер между двумя несовместимыми объектами.
 Используя паттерн адаптера, можно объединить два несовместимых интерфейса.
 Adaptee -!> Target
 Adaptee -> Adapter -> Target
 Адаптироватся можно от интерфейса а можно от класса.
  От интерфейса получится адаптироватся больше чем от одного класса

 Попытаемся адаптировать мышь под полет.
 */

// 1. Класс Bird (птица) — целевой класс
class Bird {
    public void fly() {
        System.out.println("Птица летит");
    }
}

// 2. Класс Mouse (мышь) — адаптируемый класс
class Mouse {
    public void squeak() {
        System.out.println("Мышь мышится");
    }
}

// 3. Адаптер, который наследует Mouse и "притворяется" Bird
class MouseAdapter extends Mouse { // Наследуем Mouse
    private Bird bird; // Ссылка на Bird для делегирования

    public MouseAdapter(Bird bird) {
        this.bird = bird; // Инициализация адаптера
    }

    // Метод, который адаптирует Mouse к Bird
    public void fly() {
        System.out.print("Мышь пытается летать: ");
        squeak(); // Мышь не умеет летать, поэтому она пищит
    }
}

// 4. Клиентский код
public class AdapterTest {
    public static void main(String[] args) {
        // Создаем объект Bird (птица)
        Bird bird = new Bird();

        // Создаем адаптер, передавая ему Bird
        MouseAdapter mouseAdapter = new MouseAdapter(bird);

        // Вызываем метод fly() через адаптер
        mouseAdapter.fly(); // Вывод: "Мышь пытается летать: Мышь мышится"
    }
}