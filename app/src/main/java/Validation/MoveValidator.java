package Validation;

import ChessGame.Position;
import Enums.GameMode;
import Enums.PieceType;
import Exceptions.PositionWithoutPieceException;
import Interfaces.MovementValidator;
import Validation.Movement.Moveset.CapablancaMoveSetValidator;
import Validation.Movement.Moveset.ClassicMoveSetValidator;
import Interfaces.MoveSetValidator;

import java.util.Map;

public class MoveValidator {
    private Map<PieceType, MovementValidator> pieceMovements;

    public MoveValidator(GameMode gameMode) {
        MoveSetValidator moveSet;
        switch (gameMode){
            case CAPABLANCA -> moveSet = new CapablancaMoveSetValidator();
            default -> moveSet = new ClassicMoveSetValidator();
        }
        this.pieceMovements = moveSet.loadMoveSetValidators();
    }

    public boolean validate(boolean p1turn, Position startPosition, Position finalPosition) {
        try {
            MovementValidator pieceMovementValidator = pieceMovements.get(startPosition.getPiece().getType());
            return pieceMovementValidator.validateMove(p1turn, startPosition, finalPosition);
        } catch (PositionWithoutPieceException ignored) {
            return false;
        }
    }
}
