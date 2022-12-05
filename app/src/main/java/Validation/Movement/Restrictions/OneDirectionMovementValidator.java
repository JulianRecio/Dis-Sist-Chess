package Validation.Movement.Restrictions;

import ChessGame.Position;
import Exceptions.PositionWithoutPieceException;
import Interfaces.MovementValidator;
import Validation.Movement.AbstractMovementValidator;

import java.util.HashSet;
import java.util.Set;

public class OneDirectionMovementValidator extends AbstractMovementValidator {

    public OneDirectionMovementValidator() {
        super(new HashSet<>());
    }

    @Override
    public boolean validateMove(boolean turn, Position startPosition, Position finalPosition) throws PositionWithoutPieceException {
        if(turn){
            return super.validateRestrictions(turn, startPosition, finalPosition) && finalPosition.getVerticalPosition() - startPosition.getVerticalPosition() >= 0;
        }else{
            return super.validateRestrictions(turn, startPosition, finalPosition) && finalPosition.getVerticalPosition() - startPosition.getVerticalPosition() <= 0;
        }
    }
}
