package ru.bryzgalin.incapsulationTasks.accsTransactions;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String name;
    List<Transaction> History = new ArrayList<>();
    @Getter
    private int balance;

    public Account(int balance, String name) {
        this.balance = balance;
        this.name = name;
    }
    public Account(String name){
        this(0, name);
    }

    public void takeMoneyFrom(Account accFrom, int money){
        accFrom.transferMoneyTo(this, money);
    }
    public boolean transferMoneyTo(Account accTo, int money){
        if(checkValid(money)) {
            this.setBalance(this.getBalance()-money);
            accTo.setBalance(accTo.getBalance()+money);
            addRecord(new Transaction(this,accTo,money));
            accTo.addRecord(new Transaction(accTo,this,money));
            return true;
        }
        return false;
    }
    private void setBalance(int balance) {
        this.balance = balance;
    }
    private boolean checkValid(int moneyToTake){
        return (moneyToTake <= this.getBalance());
    }
    private void addRecord(Transaction tr){
        History.add(tr);
    }
    public List<Transaction> getHistory() {
        return new ArrayList<>(History);
    }

    @Override
    public String toString() {
        return name + ": " + balance;
    }
}
