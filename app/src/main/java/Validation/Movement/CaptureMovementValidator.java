package Validation.Movement;

import ChessGame.Position;
import Enums.Color;
import Enums.PieceType;
import Exceptions.PositionWithoutPieceException;
import Interfaces.MovementValidator;

public class CaptureMovementValidator implements MovementValidator {

    @Override
    public boolean validateMove(boolean turn, Position startPosition, Position finalPosition) throws PositionWithoutPieceException {
        Color color = turn ? Color.WHITE : Color.BLACK;

        boolean attackDirection = color == Color.WHITE ? finalPosition.getVerticalPosition() >= startPosition.getVerticalPosition() : finalPosition.getHorizontalPosition() <= startPosition.getHorizontalPosition();

        if (startPosition.getPiece().getType() == PieceType.PAWN){
            return !finalPosition.isEmpty() && finalPosition.getPiece().getColor() != color
                    && Math.abs(finalPosition.getHorizontalPosition() - startPosition.getHorizontalPosition()) == 1
                    && Math.abs(finalPosition.getVerticalPosition() - startPosition.getVerticalPosition()) == 1
                    && attackDirection;
        }

        return false;
    }
}