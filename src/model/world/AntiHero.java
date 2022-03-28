package model.world;

/**
 * Anti-Heroes: when being attacked or attacking a hero or villain, the antihero will always
 * act as the opposite type. If attacking an antihero, damage is calculated normally.
 */
public class AntiHero extends Champion {

    public AntiHero(String name, int maxHP, int mana, 
                int maxActionPointsPerTurn, int speed, int attackRange, int attackDamage) {
        super(
            name, 
            maxHP, 
            mana, 
            maxActionPointsPerTurn, 
            speed, 
            attackRange, 
            attackDamage);
    }   
}
