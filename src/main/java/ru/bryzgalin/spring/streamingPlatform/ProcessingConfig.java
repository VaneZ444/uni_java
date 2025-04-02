package ru.bryzgalin.spring.streamingPlatform;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.bryzgalin.spring.streamingPlatform.interfaces.DataProcessor;

import java.util.Arrays;
import java.util.List;

@Configuration
@ComponentScan("ru.bryzgalin.spring.streamingPlatform")
public class ProcessingConfig {

    @Bean
    public List<DataProcessor> dataProcessors(
            @Qualifier("toUpperCase") DataProcessor step1,
            @Qualifier("removeLetterA") DataProcessor step2,
            @Qualifier("filterLongWords") DataProcessor step3) {
        return Arrays.asList(step1, step2, step3);
    }
}