package ru.bryzgalin.reflections;

import ru.bryzgalin.annotations.Cache;

import java.lang.reflect.Proxy;

public class CacheProxyCreator {
    private  CacheProxyCreator(){

    }
    public static <T> T create(T o){
        if(o == null) return o;
        if (!o.getClass().isAnnotationPresent(Cache.class)) return o;
        return (T) Proxy
                .newProxyInstance(o.getClass().getClassLoader(), o.getClass().getInterfaces(), new ProxyHandler(o));
    }
}
