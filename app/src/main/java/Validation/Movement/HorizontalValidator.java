package Validation.Movement;

import ChessGame.Position;
import Exceptions.PositionWithoutPieceException;
import Interfaces.MovementValidator;

import java.util.HashSet;
import java.util.Set;

public class HorizontalValidator extends AbstractMovementValidator{
    public HorizontalValidator(Set<MovementValidator> moves) {
        super(moves);
    }

    public HorizontalValidator() {
        super(new HashSet<>());
    }

    @Override
    public boolean validateMove(boolean turn, Position startPosition, Position finalPosition) throws PositionWithoutPieceException {
        return super.validateRestrictions(turn, startPosition, finalPosition) && startPosition.getVerticalPosition() == finalPosition.getVerticalPosition();
    }
}
