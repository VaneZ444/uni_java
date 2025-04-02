package ru.bryzgalin.reflections.cacheTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.bryzgalin.annotations.Cache;
import ru.bryzgalin.annotations.Mutator;
import ru.bryzgalin.reflections.CacheProxyCreator;

import java.lang.reflect.Proxy;

import static org.junit.jupiter.api.Assertions.*;

public class CacheTest {

    public interface Example {
        @Cache
        String getData();

        @Mutator
        void updateData();

        String getUncachedData();

        @Cache
        String getDataWithParam(String param);
    }

    @Cache
    public class ExampleImpl implements Example {
        private int getDataCallsCount = 0;
        private int uncachedCallsCount = 0;
        private int dataWithParamCallsCount = 0;

        @Cache
        public String getData() {
            return "calls-" + (++getDataCallsCount);
        }

        @Mutator
        public void updateData() {
        }

        @Override
        public String getUncachedData() {
            return "uncached-" + (++uncachedCallsCount);
        }

        @Cache
        public String getDataWithParam(String param) {
            return "param-calls-" + (++dataWithParamCallsCount) + "-" + param;
        }
    }

    public interface AnotherService {
        @Cache
        String getAnotherData();
    }

    public static class AnotherServiceImpl implements AnotherService {
        private int count = 0;

        @Override
        public String getAnotherData() {
            return "another-" + (++count);
        }
    }

    private ExampleImpl realService;
    private Example proxy;

    @BeforeEach
    void setUp() {
        realService = new ExampleImpl();
        proxy = CacheProxyCreator.create(realService);
    }

    @Test
    @DisplayName("Кэширование методов с аннотацией @Cache")
    void shouldCacheAnnotatedMethods() {
        String first = proxy.getData();
        assertEquals("calls-1", first);
        assertEquals(1, realService.getDataCallsCount);

        String second = proxy.getData();
        assertEquals("calls-1", second);
        assertEquals(1, realService.getDataCallsCount);
    }
    @Test
    @DisplayName("Сброс кэша после вызова метода с аннотацией @Mutator")
    void shouldInvalidateCacheAfterMutator() {
        proxy.getData();
        proxy.updateData();
        String afterMutator = proxy.getData();

        assertEquals("calls-2", afterMutator);
        assertEquals(2, realService.getDataCallsCount);
    }

    @Test
    @DisplayName("Не кэшировать методы без аннотации @Cache")
    void shouldNotCacheNonAnnotatedMethods() {
        proxy.getUncachedData();
        proxy.getUncachedData();

        assertEquals(2, realService.uncachedCallsCount);
    }

    @Test
    @DisplayName("Не создавать прокси для классов без аннотации @Cache")
    void shouldNotCreateProxyForNonAnnotatedClass() {
        AnotherServiceImpl realService = new AnotherServiceImpl();
        AnotherService proxy = CacheProxyCreator.create(realService);

        proxy.getAnotherData();
        proxy.getAnotherData();

        assertFalse(Proxy.isProxyClass(proxy.getClass()));
        assertEquals(2, realService.count);
    }

    @Test
    @DisplayName("Кэширование без учета параметров метода")
    void shouldCacheWithoutConsideringParameters() {
        String param1 = proxy.getDataWithParam("test");
        String param2 = proxy.getDataWithParam("another");

        assertEquals("param-calls-1-test", param1);
        assertEquals("param-calls-1-test", param2);
        assertEquals(1, realService.dataWithParamCallsCount);
    }
    
    @Test
    @DisplayName("Сброс всех кэшей после любого мутатора")
    void shouldResetAllCachesAfterAnyMutator() {
        proxy.getData();
        proxy.getDataWithParam("first");
        proxy.updateData();

        proxy.getData();
        proxy.getDataWithParam("second");

        assertEquals(2, realService.getDataCallsCount);
        assertEquals(2, realService.dataWithParamCallsCount);
    }
}