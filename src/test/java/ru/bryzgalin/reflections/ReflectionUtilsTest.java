package ru.bryzgalin.reflections;

import ru.bryzgalin.annotations.Invoke;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ReflectionUtilsTest {

    @org.junit.jupiter.api.Test
    void testCollect() {
        // Подготовка данных для теста
        List<Class<?>> classes = List.of(TestClass1.class, TestClass2.class);

        // Вызов тестируемого метода
        Map<String, Object> result = ReflectionUtils.collect(classes);

        // Проверка результатов
        assertEquals(2, result.size());
        assertTrue(result.containsKey("method1"));
        assertTrue(result.containsKey("method2"));
        assertEquals("value1", result.get("method1"));
        assertEquals("value2", result.get("method2"));
    }

    // Пример классов для тестирования
    static class TestClass1 {
        @Invoke
        public String method1() {
            return "value1";
        }
    }

    static class TestClass2 {
        @Invoke
        public String method2() {
            return "value2";
        }
    }
}