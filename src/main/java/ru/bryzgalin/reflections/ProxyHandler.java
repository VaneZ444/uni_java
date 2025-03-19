package ru.bryzgalin.reflections;

import ru.bryzgalin.annotations.Cache;
import ru.bryzgalin.annotations.Mutator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ProxyHandler implements InvocationHandler {

    private final Object obj;
    private final Map<Method, Object> cacheMap = new HashMap<>();

    public ProxyHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Method targetMethod = findMethod(method);

        if (targetMethod.isAnnotationPresent(Mutator.class)) {
            cacheMap.clear();
            return targetMethod.invoke(obj, args);
        }

        if (targetMethod.isAnnotationPresent(Cache.class)) {
            if (!cacheMap.containsKey(targetMethod)) {
                Object result = targetMethod.invoke(obj, args);
                cacheMap.put(targetMethod, result);
                return result;
            } else {
                return cacheMap.get(targetMethod);
            }
        }

        return targetMethod.invoke(obj, args);
    }
    private Method findMethod(Method method) throws NoSuchMethodException {
        return obj.getClass().getMethod(method.getName(), method.getParameterTypes());
    }
}