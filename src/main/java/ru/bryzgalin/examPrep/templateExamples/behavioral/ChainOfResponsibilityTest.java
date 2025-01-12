package ru.bryzgalin.examPrep.templateExamples.behavioral;
/*
Chain of Responsibility (Цепочка обязанностей)
Позволяет избежать жесткой зависимости отправителя запроса от его получателя,
 при этом запрос может быть обработан несколькими объектами.
 */
// 1. Интерфейс обработчика
interface Handler {
    void setNext(Handler next); // Устанавливает следующий обработчик
    void handle(int request);   // Обрабатывает запрос
}

// 2. Конкретный обработчик 1
class HandlerA implements Handler {
    private Handler next;

    @Override
    public void setNext(Handler next) {
        this.next = next;
    }

    @Override
    public void handle(int request) {
        if (request <= 10) { // Обрабатывает запросы до 10
            System.out.println("HandlerA обработал запрос: " + request);
        } else if (next != null) { // Передает запрос дальше
            next.handle(request);
        } else {
            System.out.println("Никто не смог обработать запрос: " + request);
        }
    }
}

// 3. Конкретный обработчик 2
class HandlerB implements Handler {
    private Handler next;

    @Override
    public void setNext(Handler next) {
        this.next = next;
    }

    @Override
    public void handle(int request) {
        if (request > 10 && request <= 20) { // Обрабатывает запросы от 10 до 20
            System.out.println("HandlerB обработал запрос: " + request);
        } else if (next != null) { // Передает запрос дальше
            next.handle(request);
        } else {
            System.out.println("Никто не смог обработать запрос: " + request);
        }
    }
}

// 4. Клиентский код
public class ChainOfResponsibilityTest {
    public static void main(String[] args) {
        // Создаем обработчики
        Handler handlerA = new HandlerA();
        Handler handlerB = new HandlerB();

        // Настраиваем цепочку
        handlerA.setNext(handlerB);

        // Передаем запросы через цепочку
        handlerA.handle(5);  // Обработает HandlerA
        handlerA.handle(15); // Обработает HandlerB
        handlerA.handle(25); // Никто не обработает
    }
}