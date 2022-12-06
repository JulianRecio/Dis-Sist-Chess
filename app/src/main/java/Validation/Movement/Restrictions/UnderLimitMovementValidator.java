package Validation.Movement.Restrictions;

import ChessGame.Position;
import Exceptions.PositionWithoutPieceException;
import Interfaces.MovementValidator;
import Validation.Movement.AbstractMovementValidator;

import java.util.HashSet;
import java.util.Set;

public class UnderLimitMovementValidator extends AbstractMovementValidator {
    private int limit;
    public UnderLimitMovementValidator(int limit) {
        super(new HashSet<>());
        this.limit = limit;
    }

    @Override
    public boolean validateMove(boolean turn, Position startPosition, Position finalPosition) throws PositionWithoutPieceException {
        return super.validateRestrictions(turn, startPosition, finalPosition) && Math.abs(finalPosition.getHorizontalPosition() - startPosition.getHorizontalPosition()) <= limit && Math.abs(finalPosition.getVerticalPosition() - startPosition.getVerticalPosition()) <= limit;
    }
}
