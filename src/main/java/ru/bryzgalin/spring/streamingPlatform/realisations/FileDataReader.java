package ru.bryzgalin.spring.streamingPlatform.realisations;

import org.springframework.stereotype.Component;
import ru.bryzgalin.spring.streamingPlatform.interfaces.DataReader;

import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class FileDataReader implements DataReader {
    @Override
    public String readData(String source) {
        try {
            return new String(Files.readAllBytes(Paths.get(source)));
        } catch (Exception e) {
            throw new RuntimeException("Ошибка чтения файла", e);
        }
    }
}

