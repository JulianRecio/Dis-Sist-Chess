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

    public boolean validateMove(boolean p1turn, Board board, Position startPosition, Position finalPosition) throws InvalidMoveException {
        Color playerColor = p1turn ? Color.WHITE : Color.BLACK;
        Color enemyColor = p1turn ? Color.BLACK : Color.WHITE;

        Position kingPosition = null;
        try {
            kingPosition = board.getKingPosition(playerColor);
        } catch (PositionWithoutPieceException e) {
            throw new InvalidMoveException("no consigue el rey");
        }

        for (Position position: board.getPositions()) {
            try {
                if (!position.isEmpty() && position.getPiece().getColor() == enemyColor){
                    if (moveValidator.validate(p1turn, kingPosition, position) && availablePathValidator.validate(board,kingPosition, position)){
                        board.movePiece(finalPosition, startPosition);
                        finalPosition.setPiece(finalPosition.getPiece());
                        throw new InvalidMoveException("King in Check");
                    }
                }
            } catch (PositionWithoutPieceException e) {
                throw new InvalidMoveException("no recorre el bucle");
            }
        }

        try {
            board.movePiece(finalPosition, startPosition);
            finalPosition.setPiece(finalPosition.getPiece());
        } catch (PositionWithoutPieceException e) {
            throw new InvalidMoveException("no devuelve todo a su lugar");
        }


        return true;
    }
}
