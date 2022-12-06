package Validation;

import ChessGame.Position;
import Enums.Color;
import Exceptions.InvalidMoveException;
import Exceptions.PositionWithoutPieceException;
import Interfaces.Board;

public class CheckValidator {

    private MoveValidator moveValidator;
    private AvailablePathValidator availablePathValidator;

    public CheckValidator(MoveValidator moveValidator, AvailablePathValidator availablePathValidator) {
        this.moveValidator = moveValidator;
        this.availablePathValidator = availablePathValidator;
    }

    public boolean validateMove(boolean p1turn, Board board, Position startPosition, Position finalPosition) throws PositionWithoutPieceException, InvalidMoveException {
        Color enemyColor = p1turn ? Color.BLACK : Color.WHITE;

        Position kingPosition = board.getKingPosition(p1turn);
        for (Position position: board.getPositions()) {
            if (!position.isEmpty() && position.getPiece().getColor() == enemyColor){
                if (moveValidator.validate(p1turn,board, kingPosition, position) && availablePathValidator.validate(board,position, kingPosition)){
                    board.movePiece(startPosition, finalPosition);
                    finalPosition.setPiece(finalPosition.getPiece());
                    throw new InvalidMoveException("Check invalid");
                }
            }
        }

        board.movePiece(startPosition,finalPosition);
        finalPosition.setPiece(finalPosition.getPiece());

        return true;
    }
}
