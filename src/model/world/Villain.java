package model.world;

/**
 * Villains: they deal extra damage when attacking heroes.
 */
public class Villain extends Champion {

    public Villain(String name, int maxHP, int mana, 
                int maxActionPointsPerTurn, int speed, int attackRange, int attackDamage) {
        super(name, maxHP, mana, maxActionPointsPerTurn, speed, attackRange, attackDamage);
    }
    
}
