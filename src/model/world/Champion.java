package model.world;

import java.awt.*;
import java.util.ArrayList;

import model.abilities.Ability;
import model.effects.Effect;

public class Champion {
    private String name;
    private int maxHP;
    private int currentHP;
    private int mana;
    private int maxActionPointsPerTurn;
    private int currentActionPoints;
    private int attackRange;
    private int attackDamage;
    private int speed;
    private ArrayList<Ability> abilities;
    private ArrayList<Effect> appliedEffects;
    private Condition condition;
    private Point location;

    public Champion(String name, int maxHP, int mana, int maxActionPointsPerTurn, 
                int speed, int attackRange, int attackDamage) {
        this.name = name;
        this.maxHP = maxHP;
        this.currentHP = maxHP;
        this.mana = mana;
        this.maxActionPointsPerTurn = maxActionPointsPerTurn;
        this.currentActionPoints = maxActionPointsPerTurn;
        this.attackRange = attackRange;
        this.attackDamage = attackDamage;
        this.speed = speed;
        abilities = new ArrayList<Ability>();
        appliedEffects = new ArrayList<Effect>();
        condition = Condition.ACTIVE;
        location = null;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public String getName() {
        return name;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    // CHANGE
    // If current larger than zero then set to max (healing)
    // If current is less than zero it is set to zero (damage)
    public void setCurrentHP(int currentHP) {
        if (currentHP > maxHP) this.currentHP = maxHP;
        else if (currentHP < 0) this.currentHP = 0;
        else this.currentHP = currentHP;
    }

    public int getMaxActionPointsPerTurn() {
        return maxActionPointsPerTurn;
    }

    public void setMaxActionPointsPerTurn(int points) {
        this.maxActionPointsPerTurn = points;
    }



    public int getCurrentActionPoints() {
        return currentActionPoints;
    }

    public void setCurrentActionPoints(int currentActionPoints) {
        this.currentActionPoints = currentActionPoints;
    }

    public int getAttackRange() {
        return attackRange;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public ArrayList<Ability> getAbilities() {
        return abilities;
    }

    public ArrayList<Effect> getAppliedEffects() {
        return appliedEffects;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(int x, int y) {
        this.location = new Point(x, y);
    }
}
