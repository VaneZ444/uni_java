package ru.bryzgalin.examPrep.third.stocks;

public class Printer implements StockObserver{
    @Override
    public void update(Stock stock) {
        System.out.println(stock.getName()+":"+stock.getCost());
    }
}