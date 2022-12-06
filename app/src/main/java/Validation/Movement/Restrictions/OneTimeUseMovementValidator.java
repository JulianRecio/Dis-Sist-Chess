package Validation.Movement.Restrictions;

import ChessGame.Position;
import Exceptions.PositionWithoutPieceException;
import Validation.Movement.AbstractMovementValidator;

import java.util.HashSet;

public class OneTimeUseMovementValidator extends AbstractMovementValidator {
    public OneTimeUseMovementValidator() {
        super(new HashSet<>());
    }

    @Override
    public boolean validateMove(boolean turn, Position startPosition, Position finalPosition) throws PositionWithoutPieceException {
        return !startPosition.hasChanged() && (startPosition.getHorizontalPosition() == startPosition.getPiece().getInitialPositionValues()[0]
                && startPosition.getVerticalPosition() == startPosition.getPiece().getInitialPositionValues()[1]) ;
    }
}
