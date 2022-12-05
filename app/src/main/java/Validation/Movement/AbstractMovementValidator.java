package Validation.Movement;

import ChessGame.Position;
import Exceptions.PositionWithoutPieceException;
import Interfaces.MovementValidator;

import java.util.Set;

public class AbstractMovementValidator implements MovementValidator {
    Set<MovementValidator> moves;

    public AbstractMovementValidator(Set<MovementValidator> moves) {
        this.moves = moves;
    }

    @Override
    public boolean validateMove(boolean turn, Position startPosition, Position finalPosition) throws PositionWithoutPieceException {
        if(moves.isEmpty()) return true;
        for (MovementValidator move: moves) {
            if (move.validateMove(turn,startPosition,finalPosition)){
                return true;
            }
        }
        return false;
    }

    public boolean validateRestrictions(boolean turn, Position startPosition, Position finalPosition){
        if (moves.isEmpty()) return true;
        boolean result =  true;
        for (MovementValidator move: moves) {
            result = result && move.validateMove(turn, startPosition, finalPosition);
        }
        return result;
    }
}
