package ru.bryzgalin.sem1.examPrep.templateExamples.structural;

import java.util.HashMap;
import java.util.Map;
/*
Flyweight (Легковес)
Вместо создания большого количества похожих объектов, объекты используются повторно. Экономит память.
В примере состояние объектов разделено на используемое повторно и не используемое повторно
 */
// 1. Flyweight (Легковес) — хранит внутреннее состояние
class CharacterStyle {
    private String font;    // Внутреннее состояние
    private int size;       // Внутреннее состояние
    private String color;   // Внутреннее состояние

    public CharacterStyle(String font, int size, String color) {
        this.font = font;
        this.size = size;
        this.color = color;
    }

    public void applyStyle() {
        System.out.println("Стиль: " + font + ", " + size + "px, " + color);
    }
}

// 2. Flyweight Factory (Фабрика легковесов)
class CharacterStyleFactory {
    private static Map<String, CharacterStyle> styles = new HashMap<>();

    public static CharacterStyle getStyle(String font, int size, String color) {
        String key = font + size + color; // Уникальный ключ для стиля
        if (!styles.containsKey(key)) {
            styles.put(key, new CharacterStyle(font, size, color)); // Создаем новый стиль, если его нет
        }
        return styles.get(key); // Возвращаем существующий стиль
    }
}

// 3. Контекст (Context) — хранит внешнее состояние
class Character {
    private char symbol;          // Внешнее состояние (уникальное для каждого символа)
    private CharacterStyle style; // Ссылка на flyweight (внутреннее состояние)

    public Character(char symbol, CharacterStyle style) {
        this.symbol = symbol;
        this.style = style;
    }

    public void display() {
        System.out.print("Символ: " + symbol + " ");
        style.applyStyle(); // Применяем стиль (внутреннее состояние)
    }
}

// 4. Клиентский код
public class FlyweightTest {
    public static void main(String[] args) {
        // Создаем стили через фабрику (внутреннее состояние)
        CharacterStyle style1 = CharacterStyleFactory.getStyle("Arial", 12, "Black");
        CharacterStyle style2 = CharacterStyleFactory.getStyle("Times New Roman", 14, "Red");

        // Создаем символы с разными стилями (внешнее состояние)
        Character char1 = new Character('A', style1);
        Character char2 = new Character('B', style2);
        Character char3 = new Character('C', style1); // Повторное использование стиля

        // Отображаем символы
        char1.display(); // Вывод: "Символ: A Стиль: Arial, 12px, Black"
        char2.display(); // Вывод: "Символ: B Стиль: Times New Roman, 14px, Red"
        char3.display(); // Вывод: "Символ: C Стиль: Arial, 12px, Black"
    }
}