package Validation.Movement;

import ChessGame.Position;
import Exceptions.PositionWithoutPieceException;
import Interfaces.MovementValidator;

import java.util.HashSet;
import java.util.Set;

public class DiagonalValidator extends AbstractMovementValidator {
    public DiagonalValidator(Set<MovementValidator> moves) {
        super(moves);
    }

    public DiagonalValidator(){
        super(new HashSet<>());
    }

    @Override
    public boolean validateMove(boolean turn, Position startPosition, Position finalPosition) throws PositionWithoutPieceException {
        return super.validateMove(turn,startPosition,finalPosition) && Math.abs(finalPosition.getHorizontalPosition() - startPosition.getHorizontalPosition()) == Math.abs(finalPosition.getVerticalPosition() - startPosition.getVerticalPosition());
    }
}
