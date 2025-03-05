package ru.bryzgalin.sem1.karate;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Combo implements Action {
    private List<Action> actions = new ArrayList<>();

    public Combo(List<Action> actions) {
        this.actions = actions;
    }
    public void act(KarateKid kid){
        for(Action a: actions){
            a.act(kid);
        }
    }
    public void addAttack(Action action) {
        actions.add(action);
    }
    public void removeLastAttack(){
        actions.removeLast();
    }
}
