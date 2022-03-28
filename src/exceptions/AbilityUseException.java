package exceptions;

/**
 * A subclass of GameActionException representing an exception that occurs upon trying
 * to cast an invalid ability
 */
public class AbilityUseException extends GameActionException {

    public AbilityUseException() {
        super();
    }

    public AbilityUseException(String msg) {
        super(msg);
    }

    
}
