package Validation.Victory;

import ChessGame.Position;
import Interfaces.Board;

public interface VictoryValidation {

    public boolean validateVictory(boolean turn, Board board, Position startPosition, Position finalPosition);
}
