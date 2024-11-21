package ru.bryzgalin.karate;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Combo {
    private List<Attacker> attacks;

    public Combo() {
        this.attacks = new ArrayList<>();
    }

    public void addAttack(Attacker attacker) {
        attacks.add(attacker);
    }
    public void removeLastAttack(){
        attacks.removeLast();
    }

    public String perform(KarateGuy karateGuy) {
        String results = "";
        for (Attacker attacker : attacks){
            results = results + (attacker.strike(karateGuy)) + "\n";
        }
        return results;
    }
}
