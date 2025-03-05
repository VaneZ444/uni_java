package ru.bryzgalin.sem1.examPrep.third.stocks;

import java.util.function.Predicate;

public class Bot implements StockObserver{
    private final String stockName;
    private final Predicate<Integer> condition;
    private final String message;

    public Bot(String stockName, Predicate<Integer> condition, String message) {
        this.stockName = stockName;
        this.condition = condition;
        this.message = message;
    }

    @Override
    public void update(Stock stock) {
        if (stock.getName().equals(stockName) && condition.test(stock.getCost())) {
            System.out.println("Bot: " + message);
        }
    }
}
