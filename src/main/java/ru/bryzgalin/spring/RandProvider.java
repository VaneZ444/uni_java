package ru.bryzgalin.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
@Component
public class RandProvider {
    private final List<Integer> numbers;
    private int currentIndex;

    public RandProvider(int min, int max) {
        // Создаем список всех чисел в диапазоне
        this.numbers = IntStream.rangeClosed(min, max)
                .boxed()
                .collect(Collectors.toList());
        // Перемешиваем их
        Collections.shuffle(this.numbers);
        this.currentIndex = 0;
    }

    public int getNextUniqueNumber() {
        if (currentIndex >= numbers.size()) {
            // Если все числа использованы, перемешиваем снова
            Collections.shuffle(numbers);
            currentIndex = 0;
        }
        return numbers.get(currentIndex++);
    }
}
