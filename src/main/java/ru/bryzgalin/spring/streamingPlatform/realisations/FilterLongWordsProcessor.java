package ru.bryzgalin.spring.streamingPlatform.realisations;

import org.springframework.stereotype.Component;
import ru.bryzgalin.spring.streamingPlatform.interfaces.DataProcessor;

@Component("filterLongWords")
public class FilterLongWordsProcessor implements DataProcessor {
    @Override
    public String process(String input) {
        String[] words = input.split("\\s+");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (word.length() > 4) {
                result.append(word).append(" ");
            }
        }
        return result.toString().trim();
    }
}