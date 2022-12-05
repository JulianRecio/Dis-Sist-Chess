package Validation;

import ChessGame.Position;
import Enums.GameMode;
import Enums.PieceType;
import Exceptions.PositionWithoutPieceException;
import Interfaces.Board;
import Interfaces.MovementValidator;
import Validation.Movement.Moveset.ClassicMoveSetValidator;
import Validation.Movement.Moveset.MoveSetValidator;

import java.util.List;
import java.util.Map;

public class MoveValidator {
    private Map<PieceType, MovementValidator> pieceMovements;

    public MoveValidator(GameMode gameMode) {
        MoveSetValidator moveSet;
        switch (gameMode){
            case CLASSIC -> moveSet = new ClassicMoveSetValidator();
            default -> moveSet = new ClassicMoveSetValidator();
        }
        this.pieceMovements = moveSet.loadMoveSetValidators();
    }

    public boolean validate(boolean p1turn, Board board, Position startPosition, Position finalPosition) {
        try {
            MovementValidator pieceMovementValidator = pieceMovements.get(startPosition.getPiece().getType());
            return pieceMovementValidator.validateMove(p1turn, startPosition, finalPosition);
        } catch (PositionWithoutPieceException e) {
            //si no hay pieza, no se puede validar
            return false;
        }
    }
}
