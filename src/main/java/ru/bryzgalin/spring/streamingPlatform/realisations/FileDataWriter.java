package ru.bryzgalin.spring.streamingPlatform.realisations;

import org.springframework.stereotype.Component;
import ru.bryzgalin.spring.streamingPlatform.interfaces.DataWriter;

import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class FileDataWriter implements DataWriter {
    @Override
    public void writeData(String destination, String data) {
        try {
            Files.write(Paths.get(destination), data.getBytes());
        } catch (Exception e) {
            throw new RuntimeException("Ошибка записи файла", e);
        }
    }
}