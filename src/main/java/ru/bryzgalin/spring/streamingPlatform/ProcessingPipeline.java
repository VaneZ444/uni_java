package ru.bryzgalin.spring.streamingPlatform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bryzgalin.spring.streamingPlatform.interfaces.DataProcessor;
import ru.bryzgalin.spring.streamingPlatform.interfaces.DataReader;
import ru.bryzgalin.spring.streamingPlatform.interfaces.DataWriter;

import java.util.List;

@Service
public class ProcessingPipeline {
    private final DataReader reader;
    private final DataWriter writer;
    private final List<DataProcessor> processors; // Добавляем процессоры как зависимость

    @Autowired
    public ProcessingPipeline(DataReader reader,
                              DataWriter writer,
                              List<DataProcessor> processors) { // Внедряем все процессоры
        this.reader = reader;
        this.writer = writer;
        this.processors = processors;
    }

    public void process(String source, String destination) { // Убираем параметр processors
        String data = reader.readData(source);

        for (DataProcessor processor : processors) { // Используем внедренные процессоры
            data = processor.process(data);
        }

        writer.writeData(destination, data);
    }
}