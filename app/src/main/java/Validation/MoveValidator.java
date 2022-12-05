package Validation;

import ChessGame.Position;
import Enums.PieceType;
import Exceptions.PositionWithoutPieceException;
import Interfaces.Board;
import Interfaces.MovementValidator;

import java.util.Map;

public class MoveValidator {
    private final Map<PieceType, MovementValidator> pieceMovements;

    public MoveValidator(Map<PieceType, MovementValidator> pieceMovements) {
        this.pieceMovements = pieceMovements;
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
