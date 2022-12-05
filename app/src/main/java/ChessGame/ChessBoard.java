package ChessGame;

import Enums.Color;
import Enums.PieceType;
import Exceptions.PositionWithoutPieceException;
import Interfaces.Board;

import java.util.List;

public class ChessBoard implements Board {
    private final List<Position> positions;

    public ChessBoard(List<Position> positions) {
        this.positions = positions;
    }

    @Override
    public List<Position> getPositions() {
        return positions;
    }

    @Override
    public Position getPosition(int horizontalPosition,int verticalPosition) {
        for(Position position : positions){
            if (verticalPosition == position.getVerticalPosition() && horizontalPosition == position.getHorizontalPosition()) return position;
        }
        return null;
    }

    @Override
    public Position getKingPosition(boolean p1turn) throws PositionWithoutPieceException {
        Color color = p1turn ? Color.WHITE: Color.BLACK;
        for (Position position: positions) {
            if (position.getPiece().getType() == PieceType.KING && position.getPiece().getColor() == color)
                return position;
        }
        return null;
    }

    @Override
    public void movePiece(Position startPosition, Position finalPosition) throws PositionWithoutPieceException {
        Piece piece = startPosition.getPiece();
        startPosition.clearPiece();
        finalPosition.setPiece(piece);
    }



}
