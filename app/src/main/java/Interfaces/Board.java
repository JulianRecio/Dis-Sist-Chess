package Interfaces;

import ChessGame.Position;
import Exceptions.PositionWithoutPieceException;

import java.util.List;

public interface Board {
    List<Position> getPositions();
    
    Position getPosition(int horizontalPosition, int verticalPosition);

    Position getKingPosition(boolean p1turn) throws PositionWithoutPieceException;

    void movePiece(Position startPosition, Position finalPosition) throws PositionWithoutPieceException;
}
