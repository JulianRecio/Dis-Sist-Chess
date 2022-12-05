package Validation.Movement.Victory;

import ChessGame.Game;
import ChessGame.Position;
import Exceptions.PositionWithoutPieceException;
import Interfaces.Board;

public interface VictoryValidation {

    public boolean validateVictory(boolean turn, Board board, Position startPosition, Position finalPosition);
}
