package ru.bryzgalin.misc.reflections.readerWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ObjectsReader<T> {
    private String fileName;
    private Class<T> clazz;

    public ObjectsReader(String fileName, Class<T> clazz) {
        this.fileName = fileName;
        this.clazz = clazz;
    }
    public List<T> read() throws FileNotFoundException, ReflectiveOperationException {
        List<T> objects = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ", 2);
                String className = parts[0];
                String params = parts.length > 1 ? parts[1] : "";

                if (className.equals(clazz.getName())) {
                    T obj = clazz.getDeclaredConstructor(String.class).newInstance(params);
                    objects.add(obj);
                }
            }
        }
        return objects;
    }
}
