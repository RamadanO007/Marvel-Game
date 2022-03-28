package exceptions;

/**
 *A subclass of GameActionException representing an exception that occurs upon trying
 *to perform an action in the wrong turn
 */
public class NotYourTurnException extends GameActionException {
    public NotYourTurnException(){
        super();
    }
    public NotYourTurnException(String msg){
        super(msg);
    }
}