package ru.bryzgalin.reflections;

import org.junit.jupiter.api.Test;
import ru.bryzgalin.annotations.Invoke;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ReflectionUtilsTest {

    @Test
    void testCollect() {
        List<Class<?>> classes = List.of(TestClass1.class, TestClass2.class);

        Map<String, Object> result = ReflectionUtils.collect(classes);

        assertEquals(2, result.size());
        assertTrue(result.containsKey("method1"));
        assertTrue(result.containsKey("method2"));
        assertEquals("value1", result.get("method1"));
        assertEquals("value2", result.get("method2"));
    }

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