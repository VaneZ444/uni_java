package ru.bryzgalin.reflections;

import ru.bryzgalin.annotations.Cache;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ProxyHandler implements InvocationHandler {

    private Object obj;

    private Map<Method, Object> cacheMap = new HashMap<>();
    private Map<Field, Object> objectState = new HashMap<>();
    public ProxyHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //TODO - перегрузки
        method = obj.getClass().getMethod(method.getName());
        if (!method.isAnnotationPresent(Cache.class)) {
            return method.invoke(this.obj, args);
        }
        //TODO - сброс кэша, учесть аргументы
        if (!cacheMap.containsKey(method)) {
            Object obj2 = method.invoke(this.obj, args);
            cacheMap.put(method, obj2);
            return obj2;
        }
        return cacheMap.get(method);
    }
}
//TODO - решить : аннотация на метод или на класс, mutator