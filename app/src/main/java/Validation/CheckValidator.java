package Validation;

import ChessGame.Position;
import Enums.Color;
import Exceptions.InvalidMoveException;
import Exceptions.PositionWithoutPieceException;
import Interfaces.Board;

public class CheckValidator {

    private final MoveValidator moveValidator;
    private final AvailablePathValidator availablePathValidator;

    public CheckValidator(MoveValidator moveValidator, AvailablePathValidator availablePathValidator) {
        this.moveValidator = moveValidator;
        this.availablePathValidator = availablePathValidator;
    }

    public boolean validateMove(boolean p1turn, Board board, Position startPosition, Position finalPosition) throws PositionWithoutPieceException, InvalidMoveException {
        Color playerColor = p1turn ? Color.WHITE : Color.BLACK;
        Color enemyColor = p1turn ? Color.BLACK : Color.WHITE;

        Position kingPosition = board.getKingPosition(playerColor);

        for (Position position: board.getPositions()) {
            if (!position.isEmpty() && position.getPiece().getColor() == enemyColor){
                if (moveValidator.validate(p1turn, kingPosition, position) && availablePathValidator.validate(board,kingPosition, position)){
                    board.movePiece(finalPosition, startPosition);
                    finalPosition.setPiece(finalPosition.getPiece());
                    throw new InvalidMoveException("King in Check");
                }
            }
        }

        board.movePiece(finalPosition, startPosition);
        finalPosition.setPiece(finalPosition.getPiece());

        return true;
    }
}
