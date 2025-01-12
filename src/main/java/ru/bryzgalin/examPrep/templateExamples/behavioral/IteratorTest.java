package ru.bryzgalin.examPrep.templateExamples.behavioral;
/*
Паттерн поведения предоставляющий унифицированный способ перебора элементов коллекции
реализуется как интерфейс с методом next()
 */
import java.util.ArrayList;
import java.util.List;

interface BookIterator<T>{
    T next();
    boolean hasNext();
}
class BookCollection{
    List<String> books = new ArrayList<String>();
    public BookIterator<String> createIterator(){
        return new ConcreteBookIterator();
    }
    private class ConcreteBookIterator implements BookIterator<String> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < books.size();
        }

        @Override
        public String next() {
            return books.get(index++);
        }
    }
}

public class IteratorTest {
    public static void main(String[] args) {
        BookCollection col = new BookCollection();
        BookIterator<String> iterator = col.createIterator();
        col.books.add("book1");
        col.books.add("book2");
        col.books.add("book3");
        while (iterator.hasNext()) {
            System.out.println(iterator.next()); // Вывод: A, B, C
        }
    }
}
