package Interfaces;

import ChessGame.Position;

import java.util.List;

public interface Board {
    List<Position> getPositions();
    Position getPosition(int verticalPosition, int horizontalPosition);
}
