package Interfaces;

import ChessGame.Position;
import Enums.Color;
import Exceptions.PositionWithoutPieceException;

import java.util.List;

public interface Board {
    List<Position> getPositions();
    
    Position getPosition(int horizontalPosition, int verticalPosition);

    Position getKingPosition(Color color) throws PositionWithoutPieceException;

    void movePiece(Position startPosition, Position finalPosition) throws PositionWithoutPieceException;

    int getHeight();

    int getWidth();
}
