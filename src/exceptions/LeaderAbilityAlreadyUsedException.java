package exceptions;

/**
* A subclass of GameActionException representing an exception that occurs upon trying
* to reuse a leader ability, which is only allowed once.
*/
public class LeaderAbilityAlreadyUsedException extends GameActionException {

    public LeaderAbilityAlreadyUsedException(){
        super();

    }

    public LeaderAbilityAlreadyUsedException(String msg){
        super(msg);
    }

    
}
