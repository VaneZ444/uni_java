package ru.bryzgalin.examPrep.templateExamples.structural;

/*
Bridge (Мост)
Разделяет реализацию и абстракцию, чтобы они могли изменяться независимо друг от друга.
 Это полезно, когда у вас есть несколько классов, которые могут иметь разные реализации одного и того же функционала.
Рассмотрим пример, где у нас есть абстракция Shape (фигура) и несколько реализаций Color (цвет).
 Мы хотим, чтобы фигуры могли быть отрисованы с разными цветами,
 не создавая подклассов для каждой комбинации фигуры и цвета.
 */
// Интерфейс для реализации (цвет)
interface Color {
    String fill();
}
// Конкретная реализация цвета (красный)
class RedColor implements Color {
    @Override
    public String fill() {
        return "Color is Red";
    }
}

// Конкретная реализация цвета (синий)
class BlueColor implements Color {
    @Override
    public String fill() {
        return "Color is Blue";
    }
}
// Абстракция (фигура)
abstract class Shape {
    protected Color color;

    // Конструктор для установки реализации цвета
    public Shape(Color color) {
        this.color = color;
    }

    // Абстрактный метод для отрисовки фигуры
    abstract public String draw();
}
// Конкретная абстракция (круг)
class Circle extends Shape {
    public Circle(Color color) {
        super(color);
    }

    @Override
    public String draw() {
        return "Circle drawn. " + color.fill();
    }
}

// Конкретная абстракция (квадрат)
class Square extends Shape {
    public Square(Color color) {
        super(color);
    }

    @Override
    public String draw() {
        return "Square drawn. " + color.fill();
    }
}
public class BridgeTest {
    public static void main(String[] args) {
        Shape redCircle = new Circle(new RedColor());
        Shape blueSquare = new Square(new BlueColor());

        // Отрисовываем фигуры
        System.out.println(redCircle.draw()); // Вывод: Circle drawn. Color is Red
        System.out.println(blueSquare.draw()); // Вывод: Square drawn. Color is Blue
    }
}