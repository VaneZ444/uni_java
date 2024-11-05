package playersTeams;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Player {
    private String name;
    @Setter
    private int number = -1;
    public Player(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
