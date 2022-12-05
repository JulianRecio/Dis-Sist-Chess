package Interfaces;

import ChessGame.*;
import Exceptions.PositionWithoutPieceException;

public interface MovementValidator {
    boolean validateMove(boolean turn, Position startPosition, Position finalPosition) throws PositionWithoutPieceException;
}
