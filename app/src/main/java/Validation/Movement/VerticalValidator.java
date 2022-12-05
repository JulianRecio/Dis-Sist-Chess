package Validation.Movement;

import ChessGame.Position;
import Exceptions.PositionWithoutPieceException;
import Interfaces.MovementValidator;

import java.util.HashSet;
import java.util.Set;

public class VerticalValidator extends AbstractMovementValidator{

    public VerticalValidator(Set<MovementValidator> moves) {
        super(moves);
    }

    public VerticalValidator(int x, int y, int limit) {
        super(new HashSet<>());
    }

    @Override
    public boolean validateMove(boolean turn, Position startPosition, Position finalPosition) throws PositionWithoutPieceException {
        return super.validateRestrictions(turn, startPosition, finalPosition) && startPosition.getHorizontalPosition() == finalPosition.getHorizontalPosition();
    }
}
