
package exceptions;

/**
* Class representing a generic exception that can occur during the game play. These
* exceptions arise from any invalid action that is performed. 
* This class has four subclasses; 
*   NotEnoughResourcesException, 
*   AbilityUseException, 
*   LeaderAbilityAlreadyUsedExcecption,
*   UnallowedMovementException.
*/
public class GameActionException extends Exception {

    public GameActionException(){
        super();
    }
    public GameActionException(String msg){
        super(msg);
        
    }



    
}
