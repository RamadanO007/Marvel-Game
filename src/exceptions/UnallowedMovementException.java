package exceptions;

/**
 *A subclass of GameActionException representing an exception that occurs upon trying
 *to preform an unallowed movement.
 */
public class UnallowedMovementException extends GameActionException {
    public UnallowedMovementException(){
        super();

    }
    public UnallowedMovementException(String msg){
        super(msg);
    }
    
}
