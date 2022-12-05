package Validation.Movement;

import ChessGame.Position;
import Interfaces.MovementValidator;

import java.util.HashSet;
import java.util.Set;

public class HorizontalValidator extends AbstractMovementValidator{
    public HorizontalValidator(Set<MovementValidator> moves) {
        super(moves);
    }

    public HorizontalValidator(int x, int y, int limit) {
        super(new HashSet<>());
    }

    @Override
    public boolean validateMove(boolean turn, Position startPosition, Position finalPosition){
        return super.validateRestrictions(turn, startPosition, finalPosition) && startPosition.getVerticalPosition() == finalPosition.getVerticalPosition();
    }
}
