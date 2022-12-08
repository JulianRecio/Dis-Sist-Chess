package Validation.Movement;

import ChessGame.PieceMover;
import ChessGame.Position;
import Enums.PieceType;
import Exceptions.PositionWithoutPieceException;
import Interfaces.MovementValidator;


import java.util.Set;

public class CastlingValidator extends AbstractMovementValidator {


    private final PieceType pieceA;
    private final PieceType pieceB;

    public CastlingValidator(Set<MovementValidator> moves, PieceType pieceA, PieceType pieceB) {
        super(moves);
        this.pieceA = pieceA;
        this.pieceB = pieceB;
    }

    @Override
    public boolean validateMove(boolean turn, Position startPosition, Position finalPosition) throws PositionWithoutPieceException {
        boolean sameRow = isInSameRow(startPosition, finalPosition);

        boolean belongsToLimitRows = (startPosition.getVerticalPosition() == 1 && finalPosition.getVerticalPosition() == 1)
                || (startPosition.getVerticalPosition() == 8 && finalPosition.getVerticalPosition() == 8);


        if (startPosition.getPiece().getType() != pieceA || finalPosition.getPiece().getType() != pieceB) return false;
        if (!(sameRow && belongsToLimitRows)) return false;

        Position[] move = {startPosition, finalPosition};
        PieceMover.getInstance().moveCastling(move);

        return true;

    }

    private boolean isInSameRow(Position startPosition, Position finalPosition) {
        return startPosition.getVerticalPosition() == finalPosition.getVerticalPosition();
    }

}
