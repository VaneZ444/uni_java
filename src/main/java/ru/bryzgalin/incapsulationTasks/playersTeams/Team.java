package ru.bryzgalin.incapsulationTasks.playersTeams;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players = new ArrayList<>();
    private int capacity;

    public Team(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
    }
    public Team(String name){
        this(name,5);
    }

    public void addPlayer(Player player){
        if(player == null) throw new IllegalArgumentException("Player is null");
        if(players.size()+1>capacity) throw new RuntimeException("Adding player exceeded max team capacity");
        if(players.contains(player)) throw new IllegalArgumentException("This player is already in the team");
        players.add(player);
        player.setNumber(players.size());
    }
    public void removePlayer(Player player){
        if(player == null) throw new IllegalArgumentException("Player is null");
        if(!players.contains(player)) throw new RuntimeException("No such player found in team");
        players.remove(player);
        player.setNumber(-1);
        for(Player p: players){
            p.setNumber(players.indexOf(p)+1);
        }
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", players=" + players +
                ", capacity=" + capacity +
                '}';
    }
}
