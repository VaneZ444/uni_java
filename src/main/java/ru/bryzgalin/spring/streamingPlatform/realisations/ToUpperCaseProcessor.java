package ru.bryzgalin.spring.streamingPlatform.realisations;

import org.springframework.stereotype.Component;
import ru.bryzgalin.spring.streamingPlatform.interfaces.DataProcessor;

@Component("toUpperCase")
public class ToUpperCaseProcessor implements DataProcessor {
    @Override
    public String process(String input) {
        return input.toUpperCase();
    }
}