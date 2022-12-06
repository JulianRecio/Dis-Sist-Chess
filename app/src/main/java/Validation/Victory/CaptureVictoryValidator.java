package Validation.Victory;

import ChessGame.Position;
import Interfaces.Board;

public class CaptureVictoryValidator implements VictoryValidation{

    @Override
    public boolean validateVictory(boolean turn, Board board, Position startPosition, Position finalPosition) {
        return false;
    }
}
