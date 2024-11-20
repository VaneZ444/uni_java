package ru.bryzgalin.karate;

import java.util.ArrayList;
import java.util.List;

public class Combo {
    private List<Attack> attacks;

    public Combo() {
        this.attacks = new ArrayList<>();
    }

    public void addAttack(Attack attack) {
        attacks.add(attack);
    }
    public void removeLastAttack(){
        attacks.removeLast();
    }
    public List<Attack> getAttacks(){
        return new ArrayList<>(attacks);
    }

    public List<String> perform(KarateGuy karateGuy) {
        List<String> results = new ArrayList<>();
        for (Attack attack : attacks) {
            results.add(attack.strike(karateGuy));
        }
        return results;
    }
}
