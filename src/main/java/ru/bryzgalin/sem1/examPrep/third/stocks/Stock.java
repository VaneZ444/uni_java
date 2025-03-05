package ru.bryzgalin.sem1.examPrep.third.stocks;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Stock {
    private final String name;
    @Setter
    private int cost;
    private final List<StockObserver> observers = new ArrayList<>();

    public Stock(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public void setCost(int cost){
        this.cost = cost;
        notifyObservers();
    }

    public void addObserver(StockObserver observer){
        observers.add(observer);
    }

    public void removeObserver(StockObserver observer){
        observers.remove(observer);
    }

    private void notifyObservers(){
        observers.forEach(observer -> observer.update(this));
    }
}
