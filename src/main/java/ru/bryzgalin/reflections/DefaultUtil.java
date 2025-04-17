//package ru.bryzgalin.reflections;
//
//import lombok.SneakyThrows;
//import ru.bryzgalin.annotations.Default;
//
//import java.lang.reflect.Field;
//import java.util.*;
//import java.util.function.BiConsumer;
//
//import static ru.bryzgalin.reflections.ReflectionUtils.*;
//import static ru.bryzgalin.reflections.ReflectionUtils.getAllFields;
//
//public class DefaultUtil {
//    private static final Map<Class<?>, Object> JAVA_DEFAULTS = new HashMap<>();
//    static {
//        JAVA_DEFAULTS.put(boolean.class, false);
//        JAVA_DEFAULTS.put(byte.class,    (byte) 0);
//        JAVA_DEFAULTS.put(short.class,   (short) 0);
//        JAVA_DEFAULTS.put(int.class,     0);
//        JAVA_DEFAULTS.put(long.class,    0L);
//        JAVA_DEFAULTS.put(char.class,    '\u0000');
//        JAVA_DEFAULTS.put(float.class,   0.0f);
//        JAVA_DEFAULTS.put(double.class,  0.0d);
//    }
//
//    public static void reset(Object... objects) {
//        for (Object obj : objects) {
//            Class<?> clazz = obj.getClass();
//            List<Field> fields = (List<Field>) getAllFields(clazz);
//            Default classAnnotation = clazz.getAnnotation(Default.class);
//            Class<?> classDefaultType = classAnnotation != null ? classAnnotation.value() : null;
//
//            for (Field field : fields) {
//                processField(obj, field, classDefaultType);
//            }
//        }
//    }
//
//    private static void processField(Object obj, Field field, Class<?> classDefaultType) {
//        try {
//            Default annotation = field.getAnnotation(Default.class);
//            if (annotation == null && classDefaultType != null) {
//                annotation = classDefaultType.getAnnotation(Default.class);
//            }
//
//            if (annotation != null) {
//                setValueFromAnnotation(obj, field, annotation.value());
//            } else {
//                setDefaultJavaValue(obj, field);
//            }
//
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to reset field: " + field.getName(), e);
//        }
//    }
//    private static void setDefaultJavaValue(Object obj,Field field){
//
//    }
//    private static void setValueFromAnnotation(Object obj, Field field, Class<?> value) {
//
//    }
//TODO: fix this too
//}