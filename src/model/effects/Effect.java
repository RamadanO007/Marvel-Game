package model.effects;

public class Effect {
    private String name;
    private int duration;
    private EffectType type;

    /**
     *  A class representing Effects in the game.
     *  Recieves parameters name, duration and EffectType.
     */
    public Effect(String name, int duration, EffectType type){
        this.name = name;
        this.duration = duration;
        this.type = type;
    }

    public String getName() {
        return name;
    }
    public EffectType getType() {
        return type;
    }
 
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
