package model.abilities;

public class Ability {
    private String name;
    private int manaCost;
    private int baseCooldown;
    private int currentCooldown;
    private int castRange;
    private int requiredActionPoints;
    private AreaOfEffect castArea;
    
    public Ability(String name, int cost, int baseCoolDown, 
                int castRange, AreaOfEffect castArea, int requiredActionPoints){
      this.name = name;
      this.manaCost = cost;
      this.baseCooldown = baseCoolDown;
      this.castRange = castRange;
      this.requiredActionPoints = requiredActionPoints;
      this.castArea = castArea;
    }

    public String getName() {
        return name;
    }

    public AreaOfEffect getCastArea() {
        return castArea;
    }

    public void setCastArea(AreaOfEffect castArea) {
        this.castArea = castArea;
    }

    public int getRequiredActionPoints() {
        return requiredActionPoints;
    }
   
    public int getCastRange() {
        return castRange;
    }
   
    public int getCurrentCooldown() {
        return currentCooldown;
    }
    public void setCurrentCooldown(int currentCooldown) {
        this.currentCooldown = currentCooldown;
    }
    public int getBaseCooldown() {
        return baseCooldown;
    }
 
    public int getManaCost() {
        return manaCost;
    }
}
