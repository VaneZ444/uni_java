package ru.bryzgalin.misc.reflections.readerWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ObjectsWriter {
    private String fileName;

    public ObjectsWriter(String fileName) {
        this.fileName = fileName;
    }

    public void write(List<?> objects) throws IOException {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (Object obj : objects) {
                writer.write(obj.getClass().getName() + " " + obj.toString() + "\n");
            }
        }
    }
}
