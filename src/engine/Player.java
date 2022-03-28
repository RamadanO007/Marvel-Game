package engine;

import java.util.ArrayList;

import model.world.Champion;

/**
 *A class representing a Player in the game
 */
public class Player {
    private String name;
    private Champion leader;
    private ArrayList<Champion> team;
    
    public Player(String name){
        this.name = name;
        team = new ArrayList<Champion>();
    }
    public String getName() {
        return name;
    }
    public Champion getLeader() {
        return leader;
    }
    public void setLeader(Champion leader) {
        this.leader = leader;
    }
    public ArrayList<Champion> getTeam() {
        return team;
    }
}
