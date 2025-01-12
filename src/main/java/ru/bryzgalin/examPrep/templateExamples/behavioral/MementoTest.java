package ru.bryzgalin.examPrep.templateExamples.behavioral;
/*
Memento
Поведенческий паттерн, который позволяет сохранять и
 восстанавливать состояние объекта без нарушения инкапсуляции.
  Он используется, когда нужно реализовать механизм отмены (undo)
   или сохранения состояния объекта, например, в текстовых редакторах или играх.


 */
// Объект, состояние которого нужно сохранить
class Editor {
    private String text;

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public Memento save() {
        return new Memento(text);
    }

    public void restore(Memento memento) {
        this.text = memento.getText();
    }
}

// Снимок (Memento)
class Memento {
    private final String text;

    public Memento(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

public class MementoTest {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.setText("Hello");
        Memento savedState = editor.save(); // Сохраняем состояние

        editor.setText("World");
        editor.restore(savedState); // Восстанавливаем состояние
        System.out.println(editor.getText()); // Вывод: Hello
    }
}
