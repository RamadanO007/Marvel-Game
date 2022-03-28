package exceptions;

/**
 *A subclass of GameActionException representing an exception that occurs upon trying
 *to perform an action in the wrong turn
 */
public class NotEnoughResourcesException extends GameActionException {
    public NotEnoughResourcesException(){
        super();
    }
    public NotEnoughResourcesException(String msg){
        super(msg);
        
    }
}
