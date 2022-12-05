package Validation.Movement.Restrictions;

import ChessGame.Position;
import Exceptions.PositionWithoutPieceException;
import Interfaces.MovementValidator;
import Validation.Movement.AbstractMovementValidator;

import java.util.HashSet;
import java.util.Set;

public class OneTimeUseMovementValidator extends AbstractMovementValidator {
    public OneTimeUseMovementValidator(Set<MovementValidator> moves) {
        super(new HashSet<>());
    }

    @Override
    public boolean validateMove(boolean turn, Position startPosition, Position finalPosition) throws PositionWithoutPieceException {
        return !startPosition.hasChanged() && (startPosition.getHorizontalPosition() == startPosition.getPiece().getInitialPositionValues()[0] && startPosition.getVerticalPosition() == startPosition.getPiece().getInitialPositionValues()[1]) ;
    }
}
