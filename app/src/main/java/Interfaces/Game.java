package Interfaces;

import ChessGame.*;
import Exceptions.InvalidMoveException;
import Exceptions.PositionWithoutPieceException;

public interface Game {
    void movePiece(int startX, int startY, int finishX, int finishY) throws PositionWithoutPieceException, InvalidMoveException;
}
