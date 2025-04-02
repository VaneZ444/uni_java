package ru.bryzgalin.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Comparator;
import java.util.List;

@Configuration
public class ReviewConfig {
    @Bean
    public Review review1() {
        return new Review("Очень хорошо", 4);
    }

    @Bean
    public Review review2() {
        return new Review("Сойдет", 3);
    }

    @Bean
    public Review review3(RandProvider randomProvider) {
        int randomRating = randomProvider.getNextUniqueNumber();
        return new Review("Сложно сказать", randomRating);
    }
    @Bean
    public Review bestReview(List<Review> allReviews) {
        return allReviews.stream()
                .max(Comparator.comparingInt(Review::getRating))
                .orElseThrow(() -> new IllegalStateException("Нет доступных отзывов"));
    }
}
