package ru.bryzgalin.sem1.examPrep.templateExamples.structural;
/*
Proxy (Заместитель)
Представляет объекты, которые могут контролировать другие объекты перехватывая их вызовы.
 Можно перехватить вызов оригинального объекта и добавить поведения не изменяя класс.
*/

// 1. Интерфейс, который определяет общий метод
interface Service {
    void doWork();
}

// 2. Реальный объект
class RealService implements Service {
    @Override
    public void doWork() {
        System.out.println("Реальный объект: работа выполнена!");
    }
}

// 3. Прокси (заместитель)
class ProxyService implements Service {
    private RealService realService; // Ссылка на реальный объект

    @Override
    public void doWork() {
        if (realService == null) {
            realService = new RealService(); // Ленивая инициализация
        }
        System.out.println("Прокси: выполняется дополнительная логика.");
        realService.doWork(); // Делегирование вызова реальному объекту
    }
}

// 4. Клиентский код
public class Proxy {
    public static void main(String[] args) {
        Service service = new ProxyService(); // Клиент работает с прокси
        service.doWork(); // Вывод: "Прокси: выполняется дополнительная логика.", "Реальный объект: работа выполнена!"
    }
}